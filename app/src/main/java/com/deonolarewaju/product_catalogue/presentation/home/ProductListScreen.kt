package com.deonolarewaju.product_catalogue.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = state.isRefreshing
    )
    var product by rememberSaveable { mutableStateOf<Product?>(null) }

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            viewModel.onEvent(ProductListEvent.Refresh)
        }) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(state.products.size) { i ->
                val product = state.products[i]
                ProductListItem(
                    product = product,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {

                        }
                )
            }
        }
    }
}