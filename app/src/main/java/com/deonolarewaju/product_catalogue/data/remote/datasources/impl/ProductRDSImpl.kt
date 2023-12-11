package com.deonolarewaju.product_catalogue.data.remote.datasources.impl

import com.deonolarewaju.product_catalogue.data.remote.ProductApi
import com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces.IProductRDS
import com.deonolarewaju.product_catalogue.domain.model.ProductsList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRDSImpl(
    private val api: ProductApi
): IProductRDS {
    override suspend fun fetchProducts(): Flow<ProductsList> = flow {
        api.fetchAllProducts()
    }
}