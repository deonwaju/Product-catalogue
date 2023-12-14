package com.deonolarewaju.product_catalogue.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deonolarewaju.product_catalogue.util.Dimens
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding2
import com.deonolarewaju.product_catalogue.util.Dimens.MediumPadding1
import com.deonolarewaju.product_catalogue.util.Dimens.SmallPadding
import com.deonolarewaju.product_catalogue.util.calculateNewPrice
import com.deonolarewaju.product_catalogue.util.formatAsCurrency

@Composable
fun ProductDetailsScreen(
    id: Int,
    detailsViewModel: ProductDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    detailsViewModel.getProduct(id)
    val product = detailsViewModel.state.product
    val discountPrice = calculateNewPrice(product.price.toDouble(), product.discountPercentage)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumPadding1),
        verticalArrangement = Arrangement.spacedBy(ExtraSmallPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .size(Dimens.ProductDetailImageSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(product.thumbnail)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(ExtraSmallPadding))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = product.title.capitalize(),
                fontSize = Dimens.MediumTextSize,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = formatAsCurrency(discountPrice),
                fontSize = Dimens.MediumTextSize,
                fontWeight = FontWeight.Light,
            )
            Spacer(modifier = Modifier.width(ExtraSmallPadding))
            Text(
                text = "$${product.price}",
                fontSize = Dimens.MediumTextSize,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
        }
        Text(
            text = product.description.trim(),
            fontSize = Dimens.MediumTextSize,
            fontWeight = FontWeight.Light,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(ExtraSmallPadding2))
        Divider(modifier = Modifier.padding(vertical = ExtraSmallPadding))
        Spacer(modifier = Modifier.height(ExtraSmallPadding2))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(product.images.size) { i ->
                val images = product.images[i]
                ProductImagesItem(url = images)
            }
        }
    }
}

@Composable
fun ProductImagesItem(url: String) {
    val context = LocalContext.current

    AsyncImage(
        modifier = Modifier
            .size(Dimens.ProductDetailImageSize)
            .clip(MaterialTheme.shapes.medium)
            .padding(SmallPadding),
        model = ImageRequest.Builder(context).data(url)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}
