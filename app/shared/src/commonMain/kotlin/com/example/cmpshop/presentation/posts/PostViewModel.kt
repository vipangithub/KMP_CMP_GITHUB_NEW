package com.example.cmpshop.presentation.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cmpshop.data.remote.paging.PostPagingSource
import com.example.cmpshop.domain.model.Post
import com.example.cmpshop.domain.usercase.GetPostsUseCase
import kotlinx.coroutines.flow.Flow

class PostViewModel(
    private val postsUseCase: GetPostsUseCase
) : ViewModel() {

    val posts: Flow<PagingData<Post>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                prefetchDistance = 5,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PostPagingSource(postsUseCase)
            }
        )
            .flow
            .cachedIn(viewModelScope)
}