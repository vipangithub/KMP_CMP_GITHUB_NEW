package com.example.cmpshop.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
import com.example.cmpshop.presentation.SplashScreen
import com.example.cmpshop.presentation.components.TextFieldComposeScreen
import com.example.cmpshop.presentation.home.HomeScreen
import com.example.cmpshop.presentation.posts.PostGridScreen
import com.example.cmpshop.presentation.posts.PostScreen
import com.example.cmpshop.presentation.posts.PostViewModel
import com.example.cmpshop.presentation.products.ProductDetailScreen
import com.example.cmpshop.presentation.products.ProductListScreen
import com.example.cmpshop.presentation.products.ProductionViewModel
import com.example.cmpshop.theme.ThemeMode
import com.example.cmpshop.ui.component.PlatformSettingsIcon

@Composable
fun AppNavigation(
    appContainer: AppContainer,
    themeMode: ThemeMode,
    onThemeModeChange: (ThemeMode) -> Unit
) {
    val navController = rememberNavController()

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

   val currentBackStackEntry =
       navController.currentBackStackEntryAsState()

    val currentDestination =
        getCurrentDestination(currentBackStackEntry.value)

    val currentTitle =
        getDestinationTitle(currentDestination)

    //val currentTitle = getDestinationTitle(currentRoute)

    val showBottomBar = currentDestination !is AppRoutes.ProductDetail

    val currentAppRoute = getCurrentAppRoute(
        navBackStackEntry.value
    )
    val isProductDetail =
        navBackStackEntry.value
            ?.destination
            ?.hasRoute(AppRoutes.ProductDetail::class) == true
    //ListExampleCompose
    AppDrawer(
        currentRoute = currentAppRoute,
        onDestinationClick = { destination ->
            navController.navigate(destination.route) {
                launchSingleTop = true
                restoreState = true
            }
        },
        destination = drawerDestinations
    ) {onMenuClick->
        Scaffold(
            topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                //  text = currentRoute ?: "CMP Shop"
                                text = currentTitle
                            )
                        },
                        navigationIcon = {
                            if (isProductDetail) {
                                IconButton(
                                    onClick = {
                                        navController.popBackStack()
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            } else {
                                IconButton(
                                    onClick = {
                                        onMenuClick()
                                    },

                                    ) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Open navigation drawer"
                                    )
                                }
                            }
                        },
                        actions = {
                            if (currentAppRoute == AppRoutes.Home || currentAppRoute == AppRoutes.Products) {
                                IconButton(onClick = {
                                    navController.navigate(
                                        AppRoutes.SettingScreen
                                    )
                                }) {
                                    PlatformSettingsIcon()
                                }
                            }
                        }
                    )
            },
            bottomBar = {
                if(showBottomBar) {
                    AppBottomBar(
                        currentDestination = currentDestination,
                        onDestinationClick = { destination ->

                            navController.navigate(destination.route) {

                                launchSingleTop = true

                                restoreState = true
                            }
                        }
                    )
                }
            }
        ) { innerPadding->

        NavHost(
            navController = navController,
            startDestination = AppRoutes.Home,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<AppRoutes.Home> {
                HomeScreen(
                    onViewProductClick = {
                        navController.navigate(AppRoutes.Products)
                    },
                    settingClick = {
                        navController.navigate(AppRoutes.SettingScreen)
                    }
                )
            }

            composable<AppRoutes.Products> {
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
                        navController.navigate(AppRoutes.ProductDetail(productId = productId))
                    },
                    onBackPress = {
                        navController.popBackStack()
                    },
                    onSettingsPress = {
                        navController.navigate(AppRoutes.SettingScreen)
                    }
                )
            }

            composable<AppRoutes.PostCompose> {
                val viewModel: PostViewModel = viewModel {
                    appContainer.createPostViewModel()
                }
                PostScreen(viewModel = viewModel, onClickBack = {
                    navController.popBackStack()
                })
            }


            composable<AppRoutes.PostGridCompose> {
                val viewModel: PostViewModel = viewModel {
                    appContainer.createPostViewModel()
                }
                PostGridScreen(viewModel = viewModel, onClickBack = {
                    navController.popBackStack()
                })
            }


            composable<AppRoutes.ProductDetail> { backStack ->
                val productDetail = backStack.toRoute<AppRoutes.ProductDetail>()
                ProductDetailScreen(
                    productId = productDetail.productId,
                    backPress = {
                        navController.popBackStack()
                    }
                )
            }
            composable<AppRoutes.SettingScreen> {
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
                         navController.navigate(AppRoutes.ListExampleCompose)
                        // navController.navigate(Route.PostCompose)
                       // navController.navigate(AppRoutes.PostGridCompose)
                    }
                )
            }
            composable<AppRoutes.ComposeSample> {
                ComposeBasicsScreen()
            }
            composable<AppRoutes.ComposeProductSample> {
                ComposeProductScreen()
            }
            composable<AppRoutes.ProductPromoCardScreen> {
                ProductPromoCardScreen()
            }
            composable<AppRoutes.ButtonsDemo> {
                ButtonsDemoScreen()
            }
            composable<AppRoutes.TextFieldCompose> {
                TextFieldComposeScreen()
            }
            composable<AppRoutes.ListExampleCompose> {
                ListExampleCompose(onClickBack = {
                    navController.popBackStack()
                })
            }
        }
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


fun getCurrentAppRoute(
    navBackStackEntry: NavBackStackEntry?
): AppRoutes? {

    val destination = navBackStackEntry?.destination
        ?: return null

    return when {
        destination.hasRoute(AppRoutes.Home::class) ->
            AppRoutes.Home

        destination.hasRoute(AppRoutes.Products::class) ->
            AppRoutes.Products

        destination.hasRoute(AppRoutes.PostCompose::class) ->
            AppRoutes.PostCompose

        destination.hasRoute(AppRoutes.SettingScreen::class) ->
            AppRoutes.SettingScreen

        destination.hasRoute(AppRoutes.ComposeProductSample::class) ->
            AppRoutes.ComposeProductSample

        destination.hasRoute(AppRoutes.ComposeSample::class) ->
            AppRoutes.ComposeSample

        destination.hasRoute(AppRoutes.ProductPromoCardScreen::class) ->
            AppRoutes.ProductPromoCardScreen

        destination.hasRoute(AppRoutes.ButtonsDemo::class) ->
            AppRoutes.ButtonsDemo

        destination.hasRoute(AppRoutes.TextFieldCompose::class) ->
            AppRoutes.TextFieldCompose

        destination.hasRoute(AppRoutes.ListExampleCompose::class) ->
            AppRoutes.ListExampleCompose

        destination.hasRoute(AppRoutes.PostGridCompose::class) ->
            AppRoutes.PostGridCompose

        else -> null
    }
}