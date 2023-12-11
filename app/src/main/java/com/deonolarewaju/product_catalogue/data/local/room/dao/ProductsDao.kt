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
    suspend fun upsert(product: ProductEntity)

    @Delete
    suspend fun delete(product: ProductEntity)

    @Query("SELECT * FROM ProductEntity")
    fun getArticles(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM ProductEntity WHERE id=:id")
    suspend fun getArticle(id: Int): ProductEntity?
}