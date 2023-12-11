package com.deonolarewaju.product_catalogue.data.local.room.datasources.impl

import com.deonolarewaju.product_catalogue.data.local.room.dao.ProductsDao
import com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces.IProductLDS
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

class ProductLDSImpl(
    private val dao: ProductsDao
): IProductLDS {
    override suspend fun upsertProducts(product: List<ProductEntity>) = dao.upsertProducts(product)

    override suspend fun delete() = dao.delete()

    override fun getProducts(): List<ProductEntity> = dao.getProducts()

    override suspend fun getProduct(id: Int): ProductEntity? = dao.getProduct(id)
}