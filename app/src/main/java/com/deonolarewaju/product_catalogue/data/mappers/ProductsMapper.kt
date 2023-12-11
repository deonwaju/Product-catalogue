package com.deonolarewaju.product_catalogue.data.mappers

import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.domain.model.Product


fun ProductEntity.toProduct(): Product =
    Product(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
    )