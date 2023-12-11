package com.pnb.myapplication.data.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun findAll(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<Product>)

    @Query("SELECT * FROM products WHERE name LIKE '%' || :name || '%'")
    suspend fun findByName(name: String): List<Product>
}