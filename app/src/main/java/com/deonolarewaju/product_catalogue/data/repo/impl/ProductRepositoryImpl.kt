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
import java.io.IOException

class ProductRepositoryImpl(
    private val iProductLDS: IProductLDS,
    private val iProductRDS: IProductRDS
) : IProductRepository {
    override suspend fun fetchProducts(): Flow<Resource<ProductsList>> = flow {

        try {
            emit(Resource.Loading(true))

            val remoteProducts = iProductRDS.fetchProducts()
            remoteProducts.let { productsList ->
                delete()
                upsertProducts(productsList.products.map { it.toProductEntity() })
                emit(Resource.Success(data = productsList))
            }
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("An error occurred!!!"))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("An error occurred!!!"))
        } finally {
            emit(Resource.Loading(false))
        }
    }

    override suspend fun upsertProducts(product: List<ProductEntity>) =
        iProductLDS.upsertProducts(product)

    override suspend fun delete() = iProductLDS.delete()
    override suspend fun getProducts(): List<ProductEntity> = iProductLDS.getProducts()
    override suspend fun getProduct(id: Int): ProductEntity? = iProductLDS.getProduct(id)
}