package com.deonolarewaju.product_catalogue.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deonolarewaju.product_catalogue.domain.usecases.ProductsUsecases
import com.deonolarewaju.product_catalogue.util.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val productsUsecases: ProductsUsecases
) : ViewModel() {

    var state by mutableStateOf(ProductListState())

    init {
        getProductsList()
    }

    fun onEvent(event: ProductListEvent) {
        when (event) {
            ProductListEvent.Refresh -> getProductsList(true)
        }
    }

    private fun getProductsList(
        refreshDataFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            productsUsecases.getProducts(refreshDataFromRemote)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let {
                                state = state.copy(
                                    products = it
                                )
                            }
                        }

                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }

                        is Resource.Error -> {
                            state = state.copy(
                                isLoading = false,
                                error = result.message,
                                products = emptyList()
                            )
                        }
                    }
                }
        }
    }
}