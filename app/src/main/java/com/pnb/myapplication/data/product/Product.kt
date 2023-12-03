package com.pnb.myapplication.data.product

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "products")
data class Product(@PrimaryKey val id: Int, val name: String, val price: BigDecimal)