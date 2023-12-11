package com.pnb.myapplication.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pnb.myapplication.data.product.Product
import com.pnb.myapplication.data.product.ProductRepository
import com.pnb.myapplication.util.NumberFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val numberFormatter: NumberFormatter,
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _productList

    init {
        getProducts()
    }

    fun searchWords(word: String) {
        if (word.isEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                val products = productRepository.findAllProducts()
                withContext(Dispatchers.Main) {
                    _productList.value = products
                }
            }
        }
        if (word.length >= 3) {
            viewModelScope.launch(Dispatchers.IO) {
                val filteredList = productRepository.findProductByName(word)
                withContext(Dispatchers.Main) {
                    updateProductList(filteredList)
                }
            }
        }
    }

    fun formatAmount(amount: BigDecimal): String {
        return numberFormatter.formatNumber(amount)
    }

    private fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val products = productRepository.getProducts()
            productRepository.saveAllProducts(products)
            withContext(Dispatchers.Main) {
                _productList.value = products
            }
        }
    }

    private fun updateProductList(newProductList: List<Product>) {
        viewModelScope.launch {
            // _productList.emit(newProductList)
            _productList.value = newProductList
            Log.d("ProductViewModel", "Updated product list: $newProductList")
        }
    }

}