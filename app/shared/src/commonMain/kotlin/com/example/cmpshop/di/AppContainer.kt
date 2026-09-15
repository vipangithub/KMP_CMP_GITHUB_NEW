package com.example.cmpshop.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.cmpshop.data.local_db.AppDatabase
import com.example.cmpshop.data.local_db.PostLocalDataSource
import com.example.cmpshop.data.remote.repositories.product.ProductRepositoryImpl
import com.example.cmpshop.data.preferences.ThemePreferenceRepository
import com.example.cmpshop.data.remote.network.post.PostApi
import com.example.cmpshop.data.remote.network.post.PostApiImpl
import com.example.cmpshop.data.remote.network.product.ProductApi
import com.example.cmpshop.data.remote.network.product.ProductApiImp
import com.example.cmpshop.domain.repository.post.PostRepository
import com.example.cmpshop.data.remote.repositories.post.PostRepositoryImpl
import com.example.cmpshop.domain.repository.product.ProductRepository
import com.example.cmpshop.domain.usercase.GetPostsUseCase
import com.example.cmpshop.domain.usercase.GetProductUseCase
import com.example.cmpshop.presentation.posts.PostViewModel

class AppContainer(
    dataStore: DataStore<Preferences>,
    database: AppDatabase
) {

    private val productApi: ProductApi = ProductApiImp()
    private val productRepository: ProductRepository = ProductRepositoryImpl(
        productApi = productApi,
    )
    val getProductUseCase = GetProductUseCase(
        productRepository
    )

    val themePreferenceRepository = ThemePreferenceRepository(dataStore)


    private val postLocalDataSource = PostLocalDataSource(database)



    private val postApi: PostApi = PostApiImpl()
    private val postRepository: PostRepository = PostRepositoryImpl(postApi,postLocalDataSource)
    val getPostsUseCase = GetPostsUseCase(postRepository)

    fun createPostViewModel(): PostViewModel {
        return PostViewModel(
            getPostsUseCase
        )
    }


}
