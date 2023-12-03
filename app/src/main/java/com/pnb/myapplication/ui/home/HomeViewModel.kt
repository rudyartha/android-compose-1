package com.pnb.myapplication.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pnb.myapplication.data.Product
import com.pnb.myapplication.data.products
import com.pnb.myapplication.util.NumberFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val numberFormatter: NumberFormatter
) : ViewModel() {

    private val _productList = MutableStateFlow(products)
    val productList: StateFlow<List<Product>> = _productList

    fun searchWords(word: String) {
        if (word.isEmpty()) {
            updateProductList(products)
        }
        if (word.length >= 3) {
            val filteredList =
                _productList.value.filter { it.name.contains(word, ignoreCase = true) }
            updateProductList(filteredList)
        }
    }

    fun formatAmount(amount: BigDecimal): String {
        return numberFormatter.formatNumber(amount)
    }

    private fun updateProductList(newProductList: List<Product>) {
        viewModelScope.launch {
            _productList.emit(newProductList)
            Log.d("ProductViewModel", "Updated product list: $newProductList")
        }
    }

}