package com.jm.kakaotaxi.presentation.business.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Business
import com.jm.kakaotaxi.presentation.business.BusinessRoute

fun NavController.navigateToBusiness(
    navOptions: NavOptions? = null,
) {
    navigate(Business, navOptions)
}

fun NavGraphBuilder.businessNavGraph(
    innerPadding: PaddingValues,
) {
    composable<Business> {
        BusinessRoute(modifier = Modifier.padding(innerPadding))
    }
}
