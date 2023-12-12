package com.deonolarewaju.product_catalogue.presentation.home

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deonolarewaju.product_catalogue.R
import com.deonolarewaju.product_catalogue.domain.model.Product
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding
import com.deonolarewaju.product_catalogue.util.Dimens.ExtraSmallPadding2
import com.deonolarewaju.product_catalogue.util.Dimens.MediumTextSize
import com.deonolarewaju.product_catalogue.util.Dimens.ProductCardSize
import com.deonolarewaju.product_catalogue.util.Dimens.ProductImageSize
import com.deonolarewaju.product_catalogue.util.Dimens.SmallTextSize
import java.text.DecimalFormat

@Composable
fun ProductListItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val discountPrice = calculateNewPrice(product.price.toDouble(), product.discountPercentage)
    Row(
        modifier = modifier.fillMaxWidth(),
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
        Spacer(modifier = Modifier.height(ExtraSmallPadding))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ProductCardSize)
        ) {
            Row {
                Text(
                    text = product.title,
                    fontSize = MediumTextSize,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
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
                    color = colorResource(id = R.color.grey_fade_out)
                )
            }
            Spacer(modifier = Modifier.height(ExtraSmallPadding2))
            Text(
                text = product.description,
                fontSize = SmallTextSize,
                fontWeight = FontWeight.Light,
                maxLines = 3,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

fun calculateNewPrice(originalPrice: Double, discountPercentage: Double): Double {
    val discountAmount = originalPrice * (discountPercentage / 100)
    return originalPrice - discountAmount
}

fun formatAsCurrency(value: Double): String {
    val decimalFormat = DecimalFormat("0.00")
    return "$" + decimalFormat.format(value)
}

@Preview
@Composable
fun PreviewMe() {

    val product = Product(
        1,
        "",
        "",
        "",
        1.0,
        listOf(),
        2,
        1.0,
        1,
        "",
        ""
    )
    ProductListItem(product)
}