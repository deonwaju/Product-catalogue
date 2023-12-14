package com.deonolarewaju.product_catalogue.presentation.details

import com.deonolarewaju.product_catalogue.domain.model.Product

data class ProductDetailsState(
    val product: Product = Product(-1,"","","",-1.0, listOf(),-1,-1.0,-1,"","" )
)