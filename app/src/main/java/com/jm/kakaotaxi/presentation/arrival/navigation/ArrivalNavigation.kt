package com.jm.kakaotaxi.presentation.arrival.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Home
import com.jm.kakaotaxi.presentation.arrival.ArrivalRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToArrival(
    navOptions: NavOptions,
) {
    navigate(Arrival, navOptions)
}

fun NavGraphBuilder.arrivalNavGraph(
    navController: NavController,
) {
    composable<Arrival> {
        ArrivalRoute()
    }
}

@Serializable
data object Arrival
