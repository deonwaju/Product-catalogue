package com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces

import androidx.paging.PagingData
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

interface IProductLDS {

    fun getProducts(): Flow<PagingData<ProductEntity>>
}