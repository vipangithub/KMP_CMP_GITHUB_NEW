package com.example.cmpshop.domain.repository.post

import com.example.cmpshop.domain.model.Post

interface PostRepository {
    suspend fun getPosts(page: Int, pageSize: Int): List<Post>
}