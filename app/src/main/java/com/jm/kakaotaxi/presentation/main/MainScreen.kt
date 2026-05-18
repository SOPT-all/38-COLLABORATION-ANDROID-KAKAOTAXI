package com.jm.kakaotaxi.presentation.main

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    ) { innerPadding ->

        MainNavHost(
            appState = appState,
            innerPadding = innerPadding,
        )
    }
}
