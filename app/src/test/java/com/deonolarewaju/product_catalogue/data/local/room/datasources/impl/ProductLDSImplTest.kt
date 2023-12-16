package com.deonolarewaju.product_catalogue.data.local.room.datasources.impl

import com.deonolarewaju.product_catalogue.data.local.room.dao.ProductsDao
import com.deonolarewaju.product_catalogue.data.local.room.datasources.interfaces.IProductLDS
import com.deonolarewaju.product_catalogue.data.local.room.entities.ProductEntity
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class ProductLDSImplTest {


    @Mock
    private lateinit var dao: ProductsDao
    private lateinit var productLDS: IProductLDS

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        productLDS = ProductLDSImpl(dao)
    }

    @Test
    fun `upsertProducts should call dao upsertProducts`() = runBlocking {
        val productEntity1 = ProductEntity(
            id = 1,
            brand = "apple",
            category = "phones",
            description = "device for making calls",
            discountPercentage = 1.0,
            images = listOf(),
            price = 100,
            rating = 1.0,
            stock = 1,
            thumbnail = "jpeg.com",
            title = "Phone 20"
        )
        val productEntity2 = ProductEntity(
            id = 2,
            brand = "apple",
            category = "phones",
            description = "device for making calls",
            discountPercentage = 1.0,
            images = listOf(),
            price = 100,
            rating = 1.0,
            stock = 1,
            thumbnail = "jpeg.com",
            title = "Phone 20"
        )
        val productEntity3 = ProductEntity(
            id = 3,
            brand = "apple",
            category = "phones",
            description = "device for making calls",
            discountPercentage = 1.0,
            images = listOf(),
            price = 100,
            rating = 1.0,
            stock = 1,
            thumbnail = "jpeg.com",
            title = "Phone 20"
        )
        val productEntity4 = ProductEntity(
            id = 4,
            brand = "apple",
            category = "phones",
            description = "device for making calls",
            discountPercentage = 1.0,
            images = listOf(),
            price = 100,
            rating = 1.0,
            stock = 1,
            thumbnail = "jpeg.com",
            title = "Phone 20"
        )

        val productList = listOf(productEntity1, productEntity2, productEntity3, productEntity4)

        // When
        productLDS.upsertProducts(productList)

        // Then
        verify(dao).upsertProducts(productList)
    }

    @Test
    fun upsertProducts() {
    }

    @Test
    fun deleteProducts() {
    }

    @Test
    fun getProducts() {
    }

    @Test
    fun getProduct() {
    }
}


/**
@Mock
private lateinit var dao: ProductsDao

@InjectMocks
private lateinit var productLDS: IProductLDS = ProductLDSImpl(dao)

@BeforeEach
fun setUp() {
    // Initialization if needed
}

@Test
fun `upsertProducts should call dao upsertProducts`() = runBlocking {
    // Given
    val productList = listOf(ProductEntity(/* Test data */))

    // When
    productLDS.upsertProducts(productList)

    // Then
    verify(dao).upsertProducts(productList)
}

@Test
fun `deleteProducts should call dao delete`() = runBlocking {
    // When
    productLDS.deleteProducts()

    // Then
    verify(dao).delete()
}

@Test
fun `getProducts should return products from dao`() = runBlocking {
    // Given
    val expectedProducts = listOf(ProductEntity(/* Test data */))
    whenever(dao.getProducts()).thenReturn(expectedProducts)

    // When
    val actualProducts = productLDS.getProducts()

    // Then
    assert(expectedProducts == actualProducts)
}

@Test
fun `getProduct should return product from dao`() = runBlocking {
    // Given
    val productId = 1
    val expectedProduct = ProductEntity(/* Test data */)
    whenever(dao.getProduct(productId)).thenReturn(expectedProduct)

    // When
    val actualProduct = productLDS.getProduct(productId)

    // Then
    assert(expectedProduct == actualProduct)
}

**/