package com.example.cmpshop.data.remote.mapper.post

import com.example.cmpshop.domain.model.Post

fun PostDto.toDomain(): Post {
    return Post(
        id = id,
        title = title,
        body = body
    )
}
