package com.deonolarewaju.product_catalogue.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProducts(product: List<ProductEntity>)

    @Query("DELETE FROM ProductEntity")
    suspend fun delete()

    @Query("SELECT * FROM ProductEntity")
    fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM ProductEntity WHERE id=:id")
    suspend fun getProduct(id: Int): ProductEntity?

    suspend fun searchProducts(query: String): List<ProductEntity>

}