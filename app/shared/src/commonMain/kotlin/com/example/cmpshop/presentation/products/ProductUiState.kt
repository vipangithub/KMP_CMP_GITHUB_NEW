package com.example.cmpshop.presentation.products

import com.example.cmpshop.domain.model.Product

data class ProductUiState(
    val isLoading: Boolean = false,
    val product: List<Product> = emptyList(),
    val error: String? = null
)
