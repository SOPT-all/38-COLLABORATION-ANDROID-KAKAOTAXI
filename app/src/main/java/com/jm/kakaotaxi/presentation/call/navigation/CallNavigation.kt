package com.jm.kakaotaxi.presentation.call.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.presentation.call.CallRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToCall(
    navOptions: NavOptions,
) {
    navigate(Call, navOptions)
}

fun NavGraphBuilder.callNavGraph(
    navController: NavController,
) {
    composable<Call> {
        CallRoute()
    }
}

@Serializable
data object Call
