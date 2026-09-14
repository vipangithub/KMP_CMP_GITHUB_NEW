package com.example.cmpshop.domain.usercase

import com.example.cmpshop.domain.repository.post.PostRepository
import com.example.cmpshop.domain.model.Post

class GetPostsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        page: Int,
        pageSize: Int
    ): List<Post> {

        return repository.getPosts(
            page = page,
            pageSize = pageSize
        )
    }
}