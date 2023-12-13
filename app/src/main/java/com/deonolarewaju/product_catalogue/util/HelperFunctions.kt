package com.deonolarewaju.product_catalogue.util

import java.text.DecimalFormat


fun calculateNewPrice(originalPrice: Double, discountPercentage: Double): Double {
    val discountAmount = originalPrice * (discountPercentage / 100)
    return originalPrice - discountAmount
}

fun formatAsCurrency(value: Double): String {
    val decimalFormat = DecimalFormat("0.00")
    return "$" + decimalFormat.format(value)
}