package com.deonolarewaju.product_catalogue.presentation.home

sealed class ProductListEvent {
    object Refresh: ProductListEvent()
}