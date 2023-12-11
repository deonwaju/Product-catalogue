package com.deonolarewaju.product_catalogue.data.repo.interfaces

import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.domain.model.ProductsList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface IProductRepository {
    suspend fun fetchProducts(): Flow<ProductsList>
    suspend fun upsertProducts(product: List<ProductEntity>)
    suspend fun delete(product: ProductEntity)
    fun getProducts(): Flow<List<ProductEntity>>
    suspend fun getProduct(id: Int): ProductEntity?
}