package com.example.cmpshop.data.remote.network.post

import com.example.cmpshop.data.remote.mapper.post.PostDto
import com.example.cmpshop.network.HttpClientProvider
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PostApiImpl(
    //private val client: HttpClient
) : PostApi {
    private val client = HttpClientProvider.client
    override suspend fun getPosts(
        page: Int,
        pageSize: Int
    ): List<PostDto> {

        return client
            .get("https://jsonplaceholder.typicode.com/posts") {

                parameter("_page", page)
                parameter("_limit", pageSize)

            }
            .body()
    }
}

