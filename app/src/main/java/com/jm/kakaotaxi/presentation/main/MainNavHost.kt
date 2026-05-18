package com.jm.kakaotaxi.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.jm.kakaotaxi.presentation.arrival.navigation.arrivalNavGraph
import com.jm.kakaotaxi.presentation.bell.navigation.bellNavGraph
import com.jm.kakaotaxi.presentation.business.navigation.businessNavGraph
import com.jm.kakaotaxi.presentation.call.navigation.callNavGraph
import com.jm.kakaotaxi.presentation.home.navigation.homeNavGraph
import com.jm.kakaotaxi.presentation.menu.navigation.menuNavGraph
import com.jm.kakaotaxi.presentation.search.navigation.searchNavGraph
import com.jm.kakaotaxi.presentation.user.navigation.userNavGraph

@Composable
fun MainNavHost(
    appState: MainAppState,
    innerPadding: PaddingValues,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = appState.startDestination,
    ) {
        menuNavGraph(
            innerPadding = innerPadding,
        )
        businessNavGraph(
            innerPadding = innerPadding,
        )
        homeNavGraph(
            navController = navController,
            innerPadding = innerPadding,
        )
        bellNavGraph(
            innerPadding = innerPadding,
        )
        userNavGraph(
            innerPadding = innerPadding,
        )

        searchNavGraph(
            navController = navController,
            innerPadding = innerPadding,
        )

        callNavGraph(
            navController = navController,
        )

        arrivalNavGraph(
            navController = navController,
        )

    }
}
