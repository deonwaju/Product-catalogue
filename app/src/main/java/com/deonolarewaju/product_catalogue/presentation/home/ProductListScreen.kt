package com.deonolarewaju.product_catalogue.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding2
import com.deonolarewaju.product_catalogue.util.Dimens.SmallPadding
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun ProductListScreen(
    state: ProductListState,
    event: (ProductListEvent) -> Unit,
    navigateToDetails: (Product) -> Unit
) {

    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = state.isRefreshing
    )

    Box (
        modifier = Modifier
            .padding(ExtraSmallPadding2)
            .fillMaxSize()
    ){
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                event(ProductListEvent.Refresh)
            }) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                items(state.products.size) { i ->
                    val product = state.products[i]
                    product.let {
                        ProductCardItem(
                            product = product,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(SmallPadding),
                            onClick = { navigateToDetails(it) }
                        )
                    }
                }
            }
        }
    }
}