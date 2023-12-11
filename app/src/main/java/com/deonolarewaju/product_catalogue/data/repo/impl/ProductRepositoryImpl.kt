package com.deonolarewaju.product_catalogue.data.repo.impl

import com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces.IProductLDS
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.data.mappers.toProduct
import com.deonolarewaju.product_catalogue.data.mappers.toProductEntity
import com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces.IProductRDS
import com.deonolarewaju.product_catalogue.data.repo.interfaces.IProductRepository
import com.deonolarewaju.product_catalogue.domain.model.ProductsList
import com.deonolarewaju.product_catalogue.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ProductRepositoryImpl(
    private val iProductLDS: IProductLDS,
    private val iProductRDS: IProductRDS
) : IProductRepository {
    override suspend fun fetchProducts(): Flow<Resource<ProductsList>> = flow {
        emit(Resource.Loading(true))
        val products = iProductLDS.getProducts()

        val checkDb = products.isEmpty()
        val loadFromCache = !checkDb
        if (loadFromCache) {
            emit(Resource.Loading(false))
            return@flow
        }

        val remoteProducts = try {
            iProductRDS.fetchProducts()
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("An error occured...!!!"))
            null
        }
        remoteProducts?.let { productsList ->
            iProductLDS.delete()
            iProductLDS.upsertProducts(
                productsList.products.map {
                    it.toProductEntity()
                }
            )

            emit(
                Resource.Success(
                    data = iProductLDS.getProducts()
                        .map {
                            it.toProduct()
                        }
                )
            )
        }

    }

    override suspend fun upsertProducts(product: List<ProductEntity>) =
        iProductLDS.upsertProducts(product)

    override suspend fun delete() = iProductLDS.delete()

    override fun getProducts(): Flow<List<ProductEntity>> = iProductLDS.getProducts()

    override suspend fun getProduct(id: Int): ProductEntity? = iProductLDS.getProduct(id)

    private fun saveProduct(product: ProductsList) =
        product.products.map {
            ProductEntity(
                id = it.id,
                brand = it.brand,
                category = it.category,
                description = it.description,
                discountPercentage = it.discountPercentage,
                images = it.images,
                price = it.price,
                rating = it.rating,
                stock = it.stock,
                thumbnail = it.thumbnail,
                title = it.title
            )
        }.toList()

}