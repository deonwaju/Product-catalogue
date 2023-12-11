package com.deonolarewaju.product_catalogue.domain.usecases.impl

import com.deonolarewaju.product_catalogue.data.repo.interfaces.IProductRepository
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.util.Resource
import kotlinx.coroutines.flow.Flow

class DeleteProducts(
    private val iProductRepository: IProductRepository
) {
    suspend operator fun invoke() = iProductRepository.delete()
}
