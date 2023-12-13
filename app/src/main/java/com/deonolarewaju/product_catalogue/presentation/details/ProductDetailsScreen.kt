package com.deonolarewaju.product_catalogue.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deonolarewaju.product_catalogue.R
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.util.Dimens
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding
import com.deonolarewaju.product_catalogue.util.calculateNewPrice
import com.deonolarewaju.product_catalogue.util.formatAsCurrency

@Composable
fun ProductDetailsScreen(
    navController: NavController,
    product: Product
) {
    val context = LocalContext.current

    val discountPrice = calculateNewPrice(product.price.toDouble(), product.discountPercentage)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            Text(
                text = product.title,
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
            Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding))
            Text(
                text = "$${product.price}",
                fontSize = Dimens.MediumTextSize,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.grey_fade_out)
            )
        }
        Spacer(modifier = Modifier.height(ExtraSmallPadding))
        Text(
            text = product.description,
            fontSize = Dimens.MediumTextSize,
            fontWeight = FontWeight.Light,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.height(ExtraSmallPadding))
        Divider(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(ExtraSmallPadding))
        ImagesList(images = product.images)
    }
}

@Composable
fun ImagesList(images: List<String>) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(images.size) { image ->
            AsyncImage(
                modifier = Modifier
                    .size(Dimens.ProductImageSize)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context).data(image)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
