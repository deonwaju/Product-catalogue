package com.deonolarewaju.product_catalogue.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deonolarewaju.product_catalogue.data.local.converter.RoomDbConverters
import com.deonolarewaju.product_catalogue.data.local.entities.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
@TypeConverters(RoomDbConverters::class)
abstract class ProductDatabase: RoomDatabase() {
    abstract val productDao: ProductsDao
}