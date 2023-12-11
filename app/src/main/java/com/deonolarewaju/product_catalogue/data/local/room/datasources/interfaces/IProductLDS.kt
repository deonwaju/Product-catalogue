package com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces

import androidx.paging.PagingData
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

interface IProductLDS {

    suspend fun upsertProducts(product: List<ProductEntity>)
    suspend fun delete(product: ProductEntity)
    fun getProducts(): Flow<List<ProductEntity>>
    suspend fun getProduct(id: Int): ProductEntity?
}
