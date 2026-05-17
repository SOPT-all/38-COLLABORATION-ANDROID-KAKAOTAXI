package com.jm.kakaotaxi.presentation.user.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.core.navigation.MainTabRoute.User
import com.jm.kakaotaxi.presentation.user.UserRoute

fun NavController.navigateToUser(
    navOptions: NavOptions? = null,
) {
    navigate(User, navOptions)
}

fun NavGraphBuilder.userNavGraph(
    innerPadding: PaddingValues,
) {
    composable<User> {
        UserRoute(modifier = Modifier.padding(innerPadding))
    }
}
