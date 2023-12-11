package com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces

import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity

interface IProductLDS {

    suspend fun upsertProducts(product: List<ProductEntity>)
    suspend fun deleteProducts()
    suspend fun getProducts(): List<ProductEntity>
    suspend fun getProduct(id: Int): ProductEntity?
}
