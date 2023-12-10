package com.pnb.myapplication.api

import com.pnb.myapplication.data.product.Product
import retrofit2.http.GET

interface ApiService {
    @GET("api/products")
    suspend fun getProducts(): List<Product>
}