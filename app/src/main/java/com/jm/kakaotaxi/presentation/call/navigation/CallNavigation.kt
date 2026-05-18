package com.jm.kakaotaxi.presentation.call.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.presentation.arrival.navigation.navigateToArrival
import com.jm.kakaotaxi.presentation.call.CallRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToCall(
    navOptions: NavOptions? = null,
) {
    navigate(Call, navOptions)
}

fun NavGraphBuilder.callNavGraph(
    navController: NavController,
) {
    composable<Call> {
        CallRoute(
            onTaxiCallConfirmed = { navController.navigateToArrival() }
        )
    }
}

@Serializable
data object Call
