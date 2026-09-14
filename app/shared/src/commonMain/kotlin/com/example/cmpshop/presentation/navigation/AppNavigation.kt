package com.example.cmpshop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cmpshop.di.AppContainer
import com.example.cmpshop.domain.model.Product
import com.example.cmpshop.presentation.components.ButtonsDemoScreen
import com.example.cmpshop.presentation.components.ComposeBasicsScreen
import com.example.cmpshop.presentation.components.ComposeProductScreen
import com.example.cmpshop.presentation.components.ListExampleCompose
import com.example.cmpshop.presentation.components.ProductPromoCardScreen
import com.example.cmpshop.presentation.SettingsScreen
import com.example.cmpshop.presentation.components.TextFieldComposeScreen
import com.example.cmpshop.presentation.home.HomeScreen
import com.example.cmpshop.presentation.posts.PostScreen
import com.example.cmpshop.presentation.posts.PostViewModel
import com.example.cmpshop.presentation.products.ProductDetailScreen
import com.example.cmpshop.presentation.products.ProductListScreen
import com.example.cmpshop.presentation.products.ProductionViewModel
import com.example.cmpshop.theme.ThemeMode

@Composable
fun AppNavigation(
    appContainer: AppContainer,
    themeMode: ThemeMode,
    onThemeModeChange: (ThemeMode) -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreen(
                onViewProductClick = {
                    navController.navigate(Route.Products)
                },
                settingClick = {
                    navController.navigate(Route.SettingScreen)
                }
            )
        }

        composable<Route.Products> {
            //  val viewModel: ProductionViewModel = viewModel()
            val viewModel: ProductionViewModel = viewModel {
                ProductionViewModel(
                    useCase = appContainer.getProductUseCase
                )
            }
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ProductListScreen(
                //products = sampleProducts,
                uiState = uiState,
                onProductClick = { productId ->
                    navController.navigate(Route.ProductDetail(productId = productId))
                },
                onBackPress = {
                    navController.popBackStack()
                },
                onSettingsPress = {
                    navController.navigate(Route.SettingScreen)
                }
            )
        }

        composable<Route.PostCompose> {
            val viewModel: PostViewModel = viewModel {
                appContainer.createPostViewModel()
            }
            PostScreen(viewModel = viewModel, onClickBack = {
                navController.popBackStack()
            })
        }


        composable<Route.ProductDetail> { backStack ->
            val productDetail = backStack.toRoute<Route.ProductDetail>()
            ProductDetailScreen(
                productId = productDetail.productId,
                backPress = {
                    navController.popBackStack()
                }
            )
        }
        composable<Route.SettingScreen> {
            SettingsScreen(
                themeMode = themeMode,
                onThemeModeChange = onThemeModeChange,
                onBackPress = {
                    navController.popBackStack()
                },
                onClickMe = {
                    //navController.navigate(Route.ComposeSample)
                    //navController.navigate(Route.ComposeProductSample)
                   // navController.navigate(Route.ProductPromoCardScreen)
                   // navController.navigate(Route.ButtonsDemo)
                   // navController.navigate(Route.TextFieldCompose)
                   // navController.navigate(Route.ListExampleCompose)
                    navController.navigate(Route.PostCompose)
                }
            )
        }
        composable<Route.ComposeSample> {
            ComposeBasicsScreen()
        }
        composable<Route.ComposeProductSample> {
            ComposeProductScreen()
        }
        composable<Route.ProductPromoCardScreen> {
            ProductPromoCardScreen()
        }
        composable<Route.ButtonsDemo> {
            ButtonsDemoScreen()
        }
        composable<Route.TextFieldCompose> {
            TextFieldComposeScreen()
        }
        composable<Route.ListExampleCompose> {
            ListExampleCompose(onClickBack = {
                navController.popBackStack()
            })
        }
    }
}

private val sampleProducts = listOf(
    Product(
        id = 1,
        title = "Laptop",
        price = 55000.0
    ),
    Product(
        id = 2,
        title = "Phone",
        price = 30000.0
    ),
    Product(
        id = 3,
        title = "Headphones",
        price = 5000.0
    )
)