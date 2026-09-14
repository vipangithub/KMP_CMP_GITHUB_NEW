package com.example.cmpshop.data.remote.repositories.product

import com.example.cmpshop.data.remote.network.product.ProductApi
import com.example.cmpshop.domain.model.Product
import com.example.cmpshop.domain.repository.product.ProductRepository

class ProductRepositoryImpl(
    private val productApi: ProductApi
): ProductRepository {
    override suspend fun getProducts(): List<Product> {

        return productApi.getProducts().map{it}

//        return listOf(
//            Product(
//                id = 1,
//                title = "Laptop",
//                price = 55000.0
//            ),
//            Product(
//                id = 2,
//                title = "Phone",
//                price = 30000.0
//            ),
//            Product(
//                id = 3,
//                title = "Headphones",
//                price = 5000.0
//            )
//        )
//
    }
}