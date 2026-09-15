package com.example.cmpshop.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cmpshop.domain.model.Post
import com.example.cmpshop.domain.usercase.GetPostsUseCase

class PostPagingSource (private val getPosts: GetPostsUseCase
    ) : PagingSource<Int, Post>() {

        override suspend fun load(
            params: LoadParams<Int>
        ): LoadResult<Int, Post> {

            return try {

                val page = params.key ?: 1
                println(
                    "PAGING → load page=$page, loadSize=${params.loadSize}"
                )
                val posts = getPosts(
                    page = page,
                    pageSize = params.loadSize
                )
                println(
                    "PAGING ← page=$page, received=${posts.size}"
                )
                LoadResult.Page(
                    data = posts,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (posts.isEmpty()) null else page + 1
                )

            } catch (e: Exception) {

                LoadResult.Error(e)
            }
        }

        override fun getRefreshKey(
            state: PagingState<Int, Post>
        ): Int? {

            return state.anchorPosition?.let { position ->

                state.closestPageToPosition(position)?.let { page ->

                    page.prevKey?.plus(1)
                        ?: page.nextKey?.minus(1)
                }
            }
        }

}