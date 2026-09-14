package com.example.cmpshop.data.remote.repositories.post

import com.example.cmpshop.data.remote.network.post.PostApi
import com.example.cmpshop.data.remote.mapper.post.toDomain
import com.example.cmpshop.domain.repository.post.PostRepository
import com.example.cmpshop.domain.model.Post

class PostRepositoryImpl(
    private val api: PostApi
) : PostRepository {

    override suspend fun getPosts(
        page: Int,
        pageSize: Int
    ): List<Post> {

        return api
            .getPosts(
                page = page,
                pageSize = pageSize
            )
            .map { it.toDomain() }
    }
}