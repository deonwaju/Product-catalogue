package com.deonolarewaju.product_catalogue.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
): Parcelable
