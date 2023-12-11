package com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces

import com.deonolarewaju.product_catalogue.domain.model.ProductsList
import kotlinx.coroutines.flow.Flow

interface IProductRDS {
    suspend fun fetchProducts(): ProductsList
}