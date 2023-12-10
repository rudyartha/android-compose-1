package com.pnb.myapplication.api

import com.pnb.myapplication.data.product.Product
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getProducts(): List<Product> = apiService.getProducts()
}