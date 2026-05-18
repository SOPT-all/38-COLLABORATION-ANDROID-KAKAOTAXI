package com.jm.kakaotaxi.presentation.main.component

import androidx.annotation.DrawableRes
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.navigation.MainTabRoute
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Bell
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Business
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Home
import com.jm.kakaotaxi.core.navigation.MainTabRoute.Menu
import com.jm.kakaotaxi.core.navigation.MainTabRoute.User
import com.jm.kakaotaxi.core.navigation.Route

enum class BottomNavType(
    @DrawableRes val selectedIconRes: Int,
    @DrawableRes val unselectedIconRes: Int,
    val label : String,
    val route : MainTabRoute
    ){
    MENU(
        selectedIconRes = R.drawable.ic_home_navigation_menu_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_menu_unselected,
        label = "전체보기",
        route = Menu
    ),

    BUSINESS(
        selectedIconRes = R.drawable.ic_home_navigation_business_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_business_unselected,
        label = "비즈니스",
        route = Business
    ),

    HOME(
        selectedIconRes = R.drawable.ic_home_navigation_house_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_house_unselected,
        label = "홈",
        route = Home
    ),

    BELL(
        selectedIconRes = R.drawable.ic_home_navigation_bell_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_bell_unselected,
        label = "이용/알림",
        route = Bell
    ),

    USER(
        selectedIconRes = R.drawable.ic_home_navigation_user_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_user_unselected,
        label ="내 정보",
        route = User
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): BottomNavType? {
            return BottomNavType.entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return BottomNavType.entries.map { it.route }.any { predicate(it) }
        }
    }
}
