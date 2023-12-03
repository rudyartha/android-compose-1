package com.pnb.myapplication.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pnb.myapplication.data.product.Product
import com.pnb.myapplication.data.product.ProductRepository
import com.pnb.myapplication.data.products
import com.pnb.myapplication.util.NumberFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        setProducts()
    }

    fun searchWords(word: String) {
        if (word.isEmpty()) {
            updateProductList(products)
        }
        if (word.length >= 3) {
            val filteredList =
                _productList.value?.filter { it.name.contains(word, ignoreCase = true) }
            if (filteredList != null) {
                updateProductList(filteredList)
            }
        }
    }

    fun formatAmount(amount: BigDecimal): String {
        return numberFormatter.formatNumber(amount)
    }

    private fun setProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.saveAllProducts(products)
            val newProducts = productRepository.findAllProducts()
            _productList.postValue(newProducts)
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