package com.jm.kakaotaxi.presentation.menu.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Menu
import com.jm.kakaotaxi.presentation.menu.MenuRoute

fun NavController.navigateToMenu(
    navOptions: NavOptions? = null,
) {
    navigate(Menu, navOptions)
}

fun NavGraphBuilder.menuNavGraph(
    innerPadding: PaddingValues,
) {
    composable<Menu> {
        MenuRoute(modifier = Modifier.padding(innerPadding))
    }
}
