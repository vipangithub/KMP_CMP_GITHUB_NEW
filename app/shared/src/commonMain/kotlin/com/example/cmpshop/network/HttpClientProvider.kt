package com.example.cmpshop.network

import io.ktor.client.HttpClient

object HttpClientProvider {
    val client: HttpClient by lazy {
        createHttpClient()
    }
}
