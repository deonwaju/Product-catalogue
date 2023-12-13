package com.deonolarewaju.product_catalogue.navGraph

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.presentation.details.DetailsViewModel
import com.deonolarewaju.product_catalogue.presentation.details.ProductDetailsScreen
import com.deonolarewaju.product_catalogue.presentation.home.HomeViewModel
import com.deonolarewaju.product_catalogue.presentation.home.ProductListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "productListScreen") {
        composable("productListScreen") {
            val viewModel: HomeViewModel = hiltViewModel()
            val state = viewModel.state.products
            ProductListScreen(navController)
        }
        composable("productDetailsScreen") {

            navController.previousBackStackEntry?.savedStateHandle?.get<Product?>("product")
                ?.let { product ->
                    ProductDetailsScreen(
                        navController = navController,
                        product = product,
                    )
                }
        }
    }
}


private fun navigateToDetails(navController: NavController, product: Product) {
    navController.currentBackStackEntry?.savedStateHandle?.set("product", product)
    navController.navigate(
        route = "productDetailsScreen"
    )
}