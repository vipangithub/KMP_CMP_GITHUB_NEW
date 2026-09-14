package com.example.cmpshop.data.remote.network.post

import com.example.cmpshop.data.remote.mapper.post.PostDto

interface PostApi {

    suspend fun getPosts(
        page: Int,
        pageSize: Int
    ): List<PostDto>
}