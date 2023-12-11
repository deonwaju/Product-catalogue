package com.deonolarewaju.product_catalogue.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deonolarewaju.product_catalogue.data.local.room.converter.RoomDbConverters
import com.deonolarewaju.product_catalogue.data.local.room.dao.ProductsDao
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
@TypeConverters(RoomDbConverters::class)
abstract class ProductDatabase: RoomDatabase() {
    abstract val productDao: ProductsDao
}