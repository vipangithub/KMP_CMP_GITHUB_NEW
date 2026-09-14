package com.example.cmpshop.domain.usercase

import com.example.cmpshop.domain.model.Product
import com.example.cmpshop.domain.repository.product.ProductRepository

class GetProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): List<Product>{
        return productRepository.getProducts()
    }
}