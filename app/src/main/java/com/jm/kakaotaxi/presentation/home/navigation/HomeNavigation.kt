package com.jm.kakaotaxi.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Home
import com.jm.kakaotaxi.presentation.home.HomeRoute
import com.jm.kakaotaxi.presentation.search.navigation.navigateToSearch

fun NavController.navigateToHome(
    navOptions: NavOptions? = null,
) {
    navigate(Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Home> {
        HomeRoute(
            modifier = Modifier.padding(innerPadding),
            navigateToSearch = navController::navigateToSearch
        )
    }
}
