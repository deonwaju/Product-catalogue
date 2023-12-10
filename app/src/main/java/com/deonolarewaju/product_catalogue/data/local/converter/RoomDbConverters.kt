package com.deonolarewaju.product_catalogue.data.local.converter

import androidx.room.TypeConverter

class RoomDbConverters {

    @TypeConverter
    fun fromImagesList(images: List<String>?): String? {
        return images?.joinToString(separator = ",")
    }

    @TypeConverter
    fun toImagesList(imagesString: String?): List<String>? {
        return imagesString?.split(",")?.map { it.trim() }
    }
}