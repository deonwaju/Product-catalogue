package com.deonolarewaju.product_catalogue.di

import android.app.Application
import androidx.room.Room
import com.deonolarewaju.product_catalogue.BuildConfig
import com.deonolarewaju.product_catalogue.data.local.room.ProductDatabase
import com.deonolarewaju.product_catalogue.data.local.room.converter.RoomDbConverters
import com.deonolarewaju.product_catalogue.data.local.room.dao.ProductsDao
import com.deonolarewaju.product_catalogue.data.local.room.datasources.impl.ProductLDSImpl
import com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces.IProductLDS
import com.deonolarewaju.product_catalogue.data.remote.ProductApi
import com.deonolarewaju.product_catalogue.data.remote.datasources.impl.ProductRDSImpl
import com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces.IProductRDS
import com.deonolarewaju.product_catalogue.data.repo.impl.ProductRepositoryImpl
import com.deonolarewaju.product_catalogue.data.repo.interfaces.IProductRepository
import com.deonolarewaju.product_catalogue.domain.usecases.ProductsUsecases
import com.deonolarewaju.product_catalogue.domain.usecases.impl.DeleteProducts
import com.deonolarewaju.product_catalogue.domain.usecases.impl.GetProductById
import com.deonolarewaju.product_catalogue.domain.usecases.impl.GetProducts
import com.deonolarewaju.product_catalogue.util.Constants.PRODUCT_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductsApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductDatabase(
        application: Application
    ): ProductDatabase {
        return Room.databaseBuilder(
            context = application,
            ProductDatabase::class.java,
            PRODUCT_DATABASE
        )
            .addTypeConverter(RoomDbConverters())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideProductsDao(
        productsDatabase: ProductDatabase
    ): ProductsDao = productsDatabase.productDao

    @Provides
    @Singleton
    fun provideIProductLDS(
        productDao: ProductsDao
    ): IProductLDS = ProductLDSImpl(productDao)

    @Provides
    @Singleton
    fun provideIProductRDS(
        api: ProductApi
    ): IProductRDS = ProductRDSImpl(api)

    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Singleton
    fun provideIProductRepository(
        iProductLDS: IProductLDS,
        iProductRDS: IProductRDS,
        ioDispatcher: CoroutineDispatcher,
    ): IProductRepository = ProductRepositoryImpl(iProductLDS,iProductRDS, ioDispatcher)

    @Provides
    @Singleton
    fun provideProductUsecases(
        iProductRepository: IProductRepository
    ): ProductsUsecases = ProductsUsecases(
        getProducts = GetProducts(iProductRepository),
        deleteProducts = DeleteProducts(iProductRepository),
        getProductById = GetProductById(iProductRepository),
    )
}