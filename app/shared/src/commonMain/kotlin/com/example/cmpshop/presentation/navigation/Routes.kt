package com.example.cmpshop.presentation.navigation

//sealed interface Route {
//data object Home: Route
//    data object Products: Route
//    data class ProductionDetail(
//        val productId:Int
//    ): Route
//}
//

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoutes {
    @Serializable
    data object Splash: AppRoutes

    @Serializable
    data object Home : AppRoutes

    @Serializable
    data object Products : AppRoutes

    @Serializable
    data class ProductDetail(
        val productId: Int
    ) : AppRoutes

    @Serializable
    data object SettingScreen : AppRoutes {

    }

    @Serializable
    data object ComposeProductSample : AppRoutes {

    }

    @Serializable
    data object ComposeSample : AppRoutes {

    }

    @Serializable
    data object ProductPromoCardScreen : AppRoutes {

    }

    @Serializable
    data object ButtonsDemo : AppRoutes {

    }

    @Serializable
    data object TextFieldCompose : AppRoutes {

    }

    @Serializable
    data object ListExampleCompose : AppRoutes {

    }

    @Serializable
    data object PostCompose : AppRoutes {

    }

    @Serializable
    data object PostGridCompose : AppRoutes {

    }
}


