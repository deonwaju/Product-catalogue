package com.deonolarewaju.product_catalogue.data.repo.impl

import com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces.IProductLDS
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces.IProductRDS
import com.deonolarewaju.product_catalogue.data.repo.interfaces.IProductRepository
import com.deonolarewaju.product_catalogue.domain.model.ProductsList
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val iProductLDS: IProductLDS,
    private val iProductRDS: IProductRDS
) : IProductRepository {
    override suspend fun fetchProducts(): Flow<ProductsList> =
        iProductRDS.fetchProducts()

    override suspend fun upsertProducts(product: List<ProductEntity>) =
        iProductLDS.upsertProducts(product)

    override suspend fun delete(product: ProductEntity) = iProductLDS.delete(product)

    override fun getProducts(): Flow<List<ProductEntity>> = iProductLDS.getProducts()

    override suspend fun getProduct(id: Int): ProductEntity? = iProductLDS.getProduct(id)

}