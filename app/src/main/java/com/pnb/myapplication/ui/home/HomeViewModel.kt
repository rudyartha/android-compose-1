package com.pnb.myapplication.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pnb.myapplication.data.Product
import com.pnb.myapplication.data.products
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val _productList = MutableStateFlow(products)
    val productList: StateFlow<List<Product>> = _productList

    fun searchWords(word: String) {
        if (word.isEmpty()) {
            updateProductList(products)
        }
        if (word.length >= 3) {
            val filteredList = _productList.value.filter { it.name.contains(word, ignoreCase = true) }
            updateProductList(filteredList)
        }
    }

    private fun updateProductList(newProductList: List<Product>) {
        viewModelScope.launch {
            _productList.emit(newProductList)
            Log.d("ProductViewModel", "Updated product list: $newProductList")
        }
    }
}