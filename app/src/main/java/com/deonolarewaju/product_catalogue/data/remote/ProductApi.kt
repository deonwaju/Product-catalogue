package com.deonolarewaju.product_catalogue.data.remote

import retrofit2.http.GET

interface ProductApi {

    @GET("/products")
    suspend fun fetchAllProducts()
}