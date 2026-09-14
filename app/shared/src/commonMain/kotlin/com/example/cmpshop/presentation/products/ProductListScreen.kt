package com.example.cmpshop.presentation.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cmpshop.domain.model.Product
import ui.AppTopBar
import ui.WindowWidthSizeClass
import ui.rememberWindowWidthSizeClass

@Composable
fun ProductListScreen(
    //products: List<Product>,
    uiState: ProductUiState,
    onProductClick: (productId: Int) -> Unit,
    onBackPress: () -> Unit,
    onSettingsPress: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Product List",
                onBackClick = {
                    onBackPress()
                },
                onSettingClick = {
                    onSettingsPress()
                }
            )
        }
    ) { innerPadding ->
        when {
            uiState.isLoading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.error != null -> {
                Text(
                    text = uiState.error
                )
            }

            else -> {
                LazyColumn(

                    modifier = Modifier.padding(innerPadding)
                    //.windowInsetsPadding( WindowInsets.safeDrawing)
                ) {
                    items(
                        items = uiState.product,
                        key = { it.id }
                    ) { product ->
                        ProductItem(
                            product = product,
                            onClick = { onProductClick(product.id) }
                        )
                    }

                }

            }
        }

    }


}

@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit
) {
    val widthClass = rememberWindowWidthSizeClass()
    val titleStyle =
        when (widthClass) {

            WindowWidthSizeClass.Compact ->
                MaterialTheme.typography.headlineSmall

            WindowWidthSizeClass.Medium ->
                MaterialTheme.typography.headlineMedium

            WindowWidthSizeClass.Expanded ->
                MaterialTheme.typography.headlineLarge
        }

    Card(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                //  .clickable(onClick = onClick)
                .padding(16.dp)
        ) {
            Text(
                text = product.title,
                style = titleStyle
            )
            Text(
                text = "Rs ${product.price}"
            )
        }
    }
}