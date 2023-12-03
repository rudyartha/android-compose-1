package com.pnb.myapplication.data.product


import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDao: ProductDao) {
    fun findAllProducts(): List<Product> {
        return productDao.findAll()
    }

    fun saveAllProducts(products: List<Product>) {
        productDao.insertProducts(products)
    }
}