package com.jm.kakaotaxi.presentation.bell.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Bell
import com.jm.kakaotaxi.presentation.bell.BellRoute

fun NavController.navigateToBell(
    navOptions: NavOptions,
) {
    navigate(Bell, navOptions)
}

fun NavGraphBuilder.bellNavGraph(
    innerPadding: PaddingValues,
) {
    composable<Bell> {
        BellRoute(modifier = Modifier.padding(innerPadding))
    }
}
