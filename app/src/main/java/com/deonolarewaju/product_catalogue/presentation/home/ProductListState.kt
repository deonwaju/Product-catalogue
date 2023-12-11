package com.deonolarewaju.product_catalogue.presentation.home

import com.deonolarewaju.product_catalogue.domain.model.Product

data class ProductListState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null
)
