package com.deonolarewaju.product_catalogue.data.remote.datasources.impl

import com.deonolarewaju.product_catalogue.data.remote.ProductApi
import com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces.IProductRDS
import com.deonolarewaju.product_catalogue.domain.model.ProductsList
import javax.inject.Inject

class ProductRDSImpl @Inject constructor(
    private val api: ProductApi
) : IProductRDS {
    override suspend fun fetchProducts(): ProductsList =
        api.fetchAllProducts()
}