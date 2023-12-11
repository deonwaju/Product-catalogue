package com.deonolarewaju.product_catalogue.data.local.room.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@ProvidedTypeConverter
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