package com.jm.kakaotaxi.presentation.main

import android.R.attr.visible
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.main.component.MainBottomBar
import com.example.letssopt.presentation.main.component.MainTab
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.main.component.BottomNavType
import com.jm.kakaotaxi.presentation.main.component.BottomNavigationBar
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    appState: MainAppState = rememberMainAppState(),
) {
    val currentTab by appState.currentTab.collectAsStateWithLifecycle()
    val isBottomBarVisible by appState.isBottomBarVisible.collectAsStateWithLifecycle()
    val isHomeTab = currentTab == BottomNavType.HOME

    val activity = LocalActivity.current

    BackHandler(enabled = currentTab != null) {
        if (isHomeTab) {
            activity?.finish()
        } else {
            appState.navigate(BottomNavType.MENU)
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                visible = isBottomBarVisible,
                items = BottomNavType.entries.toPersistentList(),
                selectedItem = currentTab,
                onItemSelected = appState::navigate,
                modifier = Modifier.navigationBarsPadding()
            )
        },
        containerColor = KakaotaxiTheme.colors.backgroundGray,
    ) { innerPadding ->

        MainNavHost(
            appState = appState,
            innerPadding = innerPadding,
        )
    }
}
