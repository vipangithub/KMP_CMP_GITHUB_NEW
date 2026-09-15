package com.example.cmpshop.data.remote.repositories.post

import com.example.cmpshop.data.local_db.PostLocalDataSource
import com.example.cmpshop.data.remote.network.post.PostApi
import com.example.cmpshop.data.remote.mapper.post.toDomain
import com.example.cmpshop.domain.repository.post.PostRepository
import com.example.cmpshop.domain.model.Post

class PostRepositoryImpl(
    private val api: PostApi,
    private val localDataSource: PostLocalDataSource
) : PostRepository {

    override suspend fun getPosts(
        page: Int,
        pageSize: Int
    ): List<Post> {

//        return api
//            .getPosts(
//                page = page,
//                pageSize = pageSize
//            )
//            .map { it.toDomain() }
        return try {

            // 1. Try network first
            val posts = api
                .getPosts(
                    page = page,
                    pageSize = pageSize
                )
                .map { it.toDomain() }

            posts.forEach { post ->
                localDataSource.savePost(
                    id = post.id,
                    userId = post.userId,
                    title = post.title,
                    body = post.body
                )
            }

            posts
        } catch (e: Exception) {

            // 4. Network failed → use SQLDelight cache
//            localDataSource.getCachedPosts(
//                page = page,
//                pageSize = pageSize
//            )

            val cachedPosts = localDataSource.getCachedPosts(
                page = page,
                pageSize = pageSize
            )

            if (cachedPosts.isNotEmpty()) {
                cachedPosts
            } else {
                throw e
            }
        }
    }
}