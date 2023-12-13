package com.deonolarewaju.product_catalogue.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deonolarewaju.product_catalogue.presentation.details.ProductDetailsScreen
import com.deonolarewaju.product_catalogue.presentation.home.ProductListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "productListScreen") {
        composable("productListScreen") { ProductListScreen(navController) }
        composable("productDetailsScreen") { ProductDetailsScreen(navController) }
    }
}