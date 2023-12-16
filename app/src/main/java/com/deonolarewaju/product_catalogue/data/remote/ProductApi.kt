package com.deonolarewaju.product_catalogue.data.remote

import com.deonolarewaju.product_catalogue.domain.model.ProductsList
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun fetchAllProducts(): ProductsList
}