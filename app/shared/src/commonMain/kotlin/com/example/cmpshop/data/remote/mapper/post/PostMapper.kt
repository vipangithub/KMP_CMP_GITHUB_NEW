package com.example.cmpshop.data.remote.mapper.post

import com.example.cmpshop.domain.model.Post
import kotlin.Int

fun PostDto.toDomain(): Post {
    return Post(
        userId= userId,
        id = id,
        title = title,
        body = body
    )
}
