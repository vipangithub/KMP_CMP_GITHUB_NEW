package com.example.cmpshop.data.remote.network.product

import com.example.cmpshop.data.remote.mapper.product.ProductDto
import com.example.cmpshop.data.remote.mapper.product.toDomain
import com.example.cmpshop.domain.model.Product
import com.example.cmpshop.network.HttpClientProvider
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable


class ProductApiImp : ProductApi {
    override suspend fun getProducts(): List<Product> {
        return try {
            val response: ProductResponse = HttpClientProvider.client
                .get("https://dummyjson.com/products")
                .body()
            response.products.map { it.toDomain() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}

@Serializable
data class ProductResponse(
    val products: List<ProductDto>
)


