package com.jm.kakaotaxi.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Menu
import com.jm.kakaotaxi.presentation.bell.navigation.navigateToBell
import com.jm.kakaotaxi.presentation.business.navigation.navigateToBusiness
import com.jm.kakaotaxi.presentation.home.navigation.navigateToHome
import com.jm.kakaotaxi.presentation.main.component.BottomNavType
import com.jm.kakaotaxi.presentation.menu.navigation.navigateToMenu
import com.jm.kakaotaxi.presentation.user.navigation.navigateToUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Stable
class MainAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val startDestination = Menu

    private val currentDestination = navController.currentBackStackEntryFlow
        .map { it.destination }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    val currentTab: StateFlow<BottomNavType?> = currentDestination
        .map { destination ->
            BottomNavType.find { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    val isBottomBarVisible: StateFlow<Boolean> = currentDestination
        .map { destination ->
            BottomNavType.contains { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun navigate(tab: BottomNavType) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }

        when (tab) {
            BottomNavType.MENU -> navController.navigateToMenu(navOptions = navOptions)
            BottomNavType.BUSINESS -> navController.navigateToBusiness(navOptions = navOptions)
            BottomNavType.HOME -> navController.navigateToHome(navOptions = navOptions)
            BottomNavType.BELL -> navController.navigateToBell(navOptions = navOptions)
            BottomNavType.USER -> navController.navigateToUser(navOptions = navOptions)
        }
    }

}

@Composable
fun rememberMainAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): MainAppState = remember(navController, coroutineScope) {
    MainAppState(navController, coroutineScope)
}
