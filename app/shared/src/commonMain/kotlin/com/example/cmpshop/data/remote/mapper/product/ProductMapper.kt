package com.example.cmpshop.data.remote.mapper.product

import com.example.cmpshop.domain.model.Product

fun ProductDto.toDomain() = Product(
    id = id,
    title = title,
    price = price,
)