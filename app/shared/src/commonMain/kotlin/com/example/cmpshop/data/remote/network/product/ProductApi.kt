package com.example.cmpshop.data.remote.network.product

import com.example.cmpshop.domain.model.Product

interface ProductApi {
    suspend fun getProducts(): List<Product>
}
