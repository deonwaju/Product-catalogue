package com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces

import com.deonolarewaju.product_catalogue.domain.model.ProductsList

interface IProductRDS {
    suspend fun fetchProducts(): ProductsList
}