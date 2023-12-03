package com.pnb.myapplication.di

import android.content.Context
import androidx.room.Room
import com.pnb.myapplication.data.MyAppDatabase
import com.pnb.myapplication.data.product.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideProductDao(database: MyAppDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MyAppDatabase {
        return Room.databaseBuilder(
            appContext,
            MyAppDatabase::class.java,
            "MyAppDatabase.db"
        ).build()
    }
}