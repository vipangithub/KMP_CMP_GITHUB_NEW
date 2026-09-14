package com.example.cmpshop.data.remote.mapper.product

import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
)