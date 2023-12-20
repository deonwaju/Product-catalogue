package com.deonolarewaju.product_catalogue.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding2
import com.deonolarewaju.product_catalogue.util.Dimens.MediumTextSize
import com.deonolarewaju.product_catalogue.util.Dimens.ProductCardSize
import com.deonolarewaju.product_catalogue.util.Dimens.ProductImageSize
import com.deonolarewaju.product_catalogue.util.calculateNewPrice
import com.deonolarewaju.product_catalogue.util.formatAsCurrency

@Composable
fun ProductCardItem(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val context = LocalContext.current
    val discountPrice = calculateNewPrice(product.price.toDouble(), product.discountPercentage)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick?.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ProductCardSize)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(ProductImageSize)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context).data(product.thumbnail)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(ExtraSmallPadding2))
            Text(
                text = "Rating: ${product.rating}",
                fontSize = MediumTextSize,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(ExtraSmallPadding)
            )
        }
        Spacer(modifier = Modifier.width(ExtraSmallPadding2))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ProductCardSize)
        ) {
            Row {
                Text(
                    text = product.title.capitalize(),
                    fontSize = MediumTextSize,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                        .padding(end = 4.dp)
                )
                Text(
                    text = formatAsCurrency(discountPrice),
                    fontSize = MediumTextSize,
                    fontWeight = FontWeight.Light,
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding))
                Text(
                    text = "$${product.price}",
                    fontSize = MediumTextSize,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
            }
            Spacer(modifier = Modifier.height(ExtraSmallPadding2))
            Text(
                text = product.description,
                fontSize = MediumTextSize,
                fontWeight = FontWeight.Light,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview
@Composable
fun PreviewMe() {

    val product = Product(
        1,
        "",
        "",
        "hello world people, do you have what it takes to create a product with this name and description and scale it",
        1.0,
        listOf(),
        2,
        1.0,
        1,
        "",
        ""
    )
    ProductCardItem(product)
}