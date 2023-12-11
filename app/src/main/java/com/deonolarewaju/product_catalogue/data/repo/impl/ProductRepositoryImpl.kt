package com.deonolarewaju.product_catalogue.data.repo.impl

import com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces.IProductLDS
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.data.mappers.toProduct
import com.deonolarewaju.product_catalogue.data.mappers.toProductEntity
import com.deonolarewaju.product_catalogue.data.remote.datasources.interfaces.IProductRDS
import com.deonolarewaju.product_catalogue.data.repo.interfaces.IProductRepository
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ProductRepositoryImpl(
    private val iProductLDS: IProductLDS,
    private val iProductRDS: IProductRDS,
) : IProductRepository {
    override fun fetchProducts(refreshDataFromRemote: Boolean): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading(true))

        val localProductsList = iProductLDS.getProducts()
        emit(Resource.Success(data = localProductsList.map { it.toProduct() }))

        val loadDataFromLocal = localProductsList.isNotEmpty() && !refreshDataFromRemote

        if (loadDataFromLocal) {
            emit(Resource.Loading(false))
            return@flow
        }

        try {
            val remoteProducts = iProductRDS.fetchProducts()
            remoteProducts.let {
                iProductLDS.deleteProducts()
                iProductLDS.upsertProducts(it.products.map { it.toProductEntity() })

                emit(Resource.Success(data = iProductLDS.getProducts().map { it.toProduct() }))
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("An error occurred while fetching remote data!"))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("An error occurred while fetching remote data!"))
        } finally {
            emit(Resource.Loading(false))
        }
    }

    override suspend fun delete() = iProductLDS.deleteProducts()
    override suspend fun getProducts(): List<ProductEntity> = iProductLDS.getProducts()
    override suspend fun getProduct(id: Int): ProductEntity? = iProductLDS.getProduct(id)
}