package com.deonolarewaju.product_catalogue.di

import com.deonolarewaju.product_catalogue.data.remote.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductsApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig)
    }
}