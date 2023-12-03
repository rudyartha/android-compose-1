package com.pnb.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.pnb.myapplication.data.product.Product
import com.pnb.myapplication.data.product.ProductDao
import java.math.BigDecimal

class Converters {
    @TypeConverter
    fun fromBigDecimal(value: BigDecimal): String {
        return value.toString()
    }

    @TypeConverter
    fun stringToBigDecimal(value: String): BigDecimal {
        return BigDecimal(value)
    }
}

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}