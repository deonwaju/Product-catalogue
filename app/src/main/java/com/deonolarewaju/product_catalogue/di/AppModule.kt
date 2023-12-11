package com.deonolarewaju.product_catalogue.di

import android.app.Application
import androidx.room.Room
import com.deonolarewaju.product_catalogue.BuildConfig
import com.deonolarewaju.product_catalogue.data.local.room.ProductDatabase
import com.deonolarewaju.product_catalogue.data.local.room.converter.RoomDbConverters
import com.deonolarewaju.product_catalogue.data.remote.ProductApi
import com.deonolarewaju.product_catalogue.util.Constants.PRODUCT_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}