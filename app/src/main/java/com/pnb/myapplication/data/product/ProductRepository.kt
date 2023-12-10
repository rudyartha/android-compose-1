package com.pnb.myapplication.data.product


import com.pnb.myapplication.api.ApiHelper
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDao: ProductDao, private val apiHelper: ApiHelper) {
    fun findAllProducts(): List<Product> {
        return productDao.findAll()
    }

    fun saveAllProducts(products: List<Product>) {
        productDao.insertProducts(products)
    }

    suspend fun getProducts(): List<Product> = apiHelper.getProducts()
}