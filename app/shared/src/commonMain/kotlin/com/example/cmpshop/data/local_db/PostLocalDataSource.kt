package com.example.cmpshop.data.local_db

import com.example.cmpshop.domain.model.Post

class PostLocalDataSource(
    database: AppDatabase
) {

    private val queries = database.postQueries

    //    fun getCachedPosts() =
//        queries.selectAll().executeAsList()
    fun getCachedPosts(
        page: Int,
        pageSize: Int
    ): List<Post> {

        val offset = (page - 1) * pageSize

        return queries.selectPosts(
            pageSize.toLong(),
            offset.toLong()
        )

            .executeAsList()
            .map { entity ->
                Post(
                    userId = entity.userId.toInt(),
                    id = entity.id.toInt(),
                    title = entity.title,
                    body = entity.body
                )
            }
    }

    fun savePost(
        id: Int,
        userId: Int,
        title: String,
        body: String
    ) {
        queries.insertPost(
            id = id.toLong(),
            userId = userId.toLong(),
            title = title,
            body = body
        )
    }

    fun deleteAll() {
        queries.deleteAll()
    }
}