package com.deonolarewaju.product_catalogue.data.repo.interfaces

import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.util.Resource
import kotlinx.coroutines.flow.Flow

interface IProductRepository {
    fun fetchProducts(): Flow<Resource<List<Product>>>
    suspend fun delete()
    suspend fun getProducts(): List<ProductEntity>
    suspend fun getProduct(id: Int): ProductEntity?
}