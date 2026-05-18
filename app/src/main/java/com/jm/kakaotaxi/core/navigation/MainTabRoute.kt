package com.jm.kakaotaxi.core.navigation

import kotlinx.serialization.Serializable


interface MainTabRoute : Route {

    @Serializable
    data object Menu : MainTabRoute

    @Serializable
    data object Business : MainTabRoute

    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Bell : MainTabRoute

    @Serializable
    data object User : MainTabRoute
}
