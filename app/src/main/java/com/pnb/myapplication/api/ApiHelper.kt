package com.pnb.myapplication.api

import com.pnb.myapplication.data.product.Product

interface ApiHelper {
    suspend fun getProducts(): List<Product>
}