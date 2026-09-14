package com.example.cmpshop.presentation.navigation

//sealed interface Route {
//data object Home: Route
//    data object Products: Route
//    data class ProductionDetail(
//        val productId:Int
//    ): Route
//}
//

import kotlinx.serialization.SealedSerializationApi
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {

    @Serializable
    data object Home : Route

    @Serializable
    data object Products : Route

    @Serializable
    data class ProductDetail(
        val productId: Int
    ) : Route

    @Serializable
    data object SettingScreen : Route {

    }

    @Serializable
    data object ComposeProductSample : Route {

    }

    @Serializable
    data object ComposeSample : Route {

    }

    @Serializable
    data object ProductPromoCardScreen : Route {

    }

    @Serializable
    data object ButtonsDemo: Route{

    }
    @Serializable
    data object TextFieldCompose: Route{

    }
    @Serializable
    data object ListExampleCompose: Route{

    }

    @Serializable
    data object PostCompose : Route{

    }
}
