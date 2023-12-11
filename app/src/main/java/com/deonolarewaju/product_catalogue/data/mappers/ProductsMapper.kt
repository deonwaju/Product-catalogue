package com.deonolarewaju.product_catalogue.data.mappers

import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import com.deonolarewaju.product_catalogue.domain.model.Product


fun ProductEntity.toProduct(): Product =
    Product(
        id = id,
        brand = brand,
        category = category,
        description = description,
        discountPercentage = discountPercentage,
        images = images,
        price = price,
        rating = rating,
        stock = stock,
        thumbnail = thumbnail,
        title = title,
    )

fun Product.toProductEntity(): ProductEntity =
    ProductEntity(
        id = id,
        brand = brand,
        category = category,
        description = description,
        discountPercentage = discountPercentage,
        images = images,
        price = price,
        rating = rating,
        stock = stock,
        thumbnail = thumbnail,
        title = title,
    )