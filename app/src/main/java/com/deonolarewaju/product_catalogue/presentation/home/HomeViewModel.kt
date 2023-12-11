package com.deonolarewaju.product_catalogue.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deonolarewaju.product_catalogue.domain.usecases.ProductsUsecases
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    val productsUsecases: ProductsUsecases
) : ViewModel() {

    var state by mutableStateOf(ProductListState())

    init {
        getProductsList()
    }

    private fun getProductsList(
        refreshDataFromRemote: Boolean = false
    ) {
        viewModelScope.launch {

        }
    }
}