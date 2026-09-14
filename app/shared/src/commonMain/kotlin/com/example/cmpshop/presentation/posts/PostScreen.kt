package com.example.cmpshop.presentation.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.cmpshop.domain.model.Post

@Composable
fun PostScreen(
    viewModel: PostViewModel,
    onClickBack:()-> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Post") },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )

        },
    ) {inner->
        val posts = viewModel.posts.collectAsLazyPagingItems()
        when (val refreshState = posts.loadState.refresh) {

            is LoadState.Loading -> {

                FullScreenLoading()
            }

            is LoadState.Error -> {

                ErrorView(
                    message = refreshState.error.message
                        ?: "Unable to load posts",

                    onRetry = {
                        posts.retry()
                    }
                )
            }

            is LoadState.NotLoading -> {

                if (posts.itemCount == 0) {

                    EmptyView()

                } else {

                    PostList(posts,inner)
                }
            }
        }
    }
}

@Composable
fun EmptyView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("No posts found")
    }
}

@Composable
fun ErrorView(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}

@Composable
private fun PostList(
    posts: LazyPagingItems<Post>,
    padding: PaddingValues
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(
            count = posts.itemCount,

            key = posts.itemKey { post ->
                post.id
            },

            contentType = {
                "post"
            }

        ) { index ->

            val post = posts[index]

            if (post != null) {

                PostItem(post)

            } else {

               // PostPlaceholder()
            }
        }

        when (posts.loadState.append) {

            is LoadState.Loading -> {

                item {
                    LoadingFooter()
                }
            }

            is LoadState.Error -> {

                item {
                    RetryFooter(
                        onRetry = {
                            posts.retry()
                        }
                    )
                }
            }

            is LoadState.NotLoading -> Unit
        }
    }
}

@Composable
private fun PostItem(post: Post) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "#${post.id}",
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = post.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = post.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun FullScreenLoading() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator()
    }
}

@Composable
private fun LoadingFooter() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator()
    }
}

@Composable
private fun RetryFooter(
    onRetry: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Failed to load more posts"
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = onRetry
        ) {
            Text("Retry")
        }
    }
}