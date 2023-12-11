package com.deonolarewaju.product_catalogue.domain.usecases

import com.deonolarewaju.product_catalogue.domain.usecases.impl.DeleteProducts
import com.deonolarewaju.product_catalogue.domain.usecases.impl.GetProductById
import com.deonolarewaju.product_catalogue.domain.usecases.impl.GetProducts

data class ProductsUsecase(
    val getProducts: GetProducts,
    val deleteProducts: DeleteProducts,
    val getProductById: GetProductById,
)
