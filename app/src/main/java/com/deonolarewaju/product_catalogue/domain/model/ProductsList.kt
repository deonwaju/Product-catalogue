package com.deonolarewaju.product_catalogue.domain.model

data class ProductsList(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)