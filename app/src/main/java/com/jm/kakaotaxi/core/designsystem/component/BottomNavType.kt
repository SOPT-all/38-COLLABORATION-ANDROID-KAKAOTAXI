package com.jm.kakaotaxi.core.designsystem.component

import androidx.annotation.DrawableRes
import com.jm.kakaotaxi.R

enum class BottomNavType(
    @DrawableRes val selectedIconRes: Int,
    @DrawableRes val unselectedIconRes: Int,
    val label : String,

    ){
    MENU(
        selectedIconRes = R.drawable.ic_home_navigation_menu_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_menu_unselected,
        label = "전체보기"
    ),

    BUSINESS(
        selectedIconRes = R.drawable.ic_home_navigation_business_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_business_unselected,
        label = "비즈니스"
    ),

    HOUSE(
        selectedIconRes = R.drawable.ic_home_navigation_house_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_house_unselected,
        label = "홈"
    ),

    BELL(
        selectedIconRes = R.drawable.ic_home_navigation_bell_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_bell_unselected,
        label = "이용/알림"
    ),

    USER(
        selectedIconRes = R.drawable.ic_home_navigation_user_selected,
        unselectedIconRes = R.drawable.ic_home_navigation_user_unselected,
        label ="내 정보"
    )
}