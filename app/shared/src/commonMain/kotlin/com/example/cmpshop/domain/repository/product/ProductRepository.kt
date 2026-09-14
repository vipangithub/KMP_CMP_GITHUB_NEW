package com.example.cmpshop.domain.repository.product

import com.example.cmpshop.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

}