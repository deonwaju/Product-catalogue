package com.deonolarewaju.product_catalogue.domain.usecases.impl

import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.data.repo.interfaces.IProductRepository

class GetProductById(
    private val iProductRepository: IProductRepository
) {
    suspend operator fun invoke(id: Int): ProductEntity? = iProductRepository.getProduct(id)
}