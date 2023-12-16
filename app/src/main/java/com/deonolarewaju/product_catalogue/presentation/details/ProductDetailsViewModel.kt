package com.deonolarewaju.product_catalogue.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deonolarewaju.product_catalogue.domain.usecases.ProductsUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val productsUsecases: ProductsUsecases
) : ViewModel() {

    var state by mutableStateOf(ProductDetailsState())

    fun getProduct(id: Int) {
        viewModelScope.launch {
            state = try {
                val product = productsUsecases.getProductById(id)
                if (product != null) {
                    state.copy(product = product, error = null)
                } else {
                    state.copy(error = "Product not found")
                }
            } catch (e: Exception) {
                state.copy(error = e.message)
            }
        }
    }
}