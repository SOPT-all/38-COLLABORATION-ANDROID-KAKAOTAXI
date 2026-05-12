package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R

@Composable
fun BottomNavigationBar(
){
    var selectedIndex by remember {
        mutableStateOf(-1)
    }
    Row(
        modifier = Modifier
            .padding(start = 25.dp, end = 24.dp)
            .padding(top = 8.dp, bottom = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ){
        BottomNavItem(
            icon = R.drawable.ic_homenavigation_menu,
            label = "전체보기",
            isSelected = selectedIndex == 0,
            onClick = {
                selectedIndex = 0
            }
        )

        BottomNavItem(
            icon = R.drawable.ic_homenavigation_business,
            label = "비즈니스",
            isSelected = selectedIndex == 1,
            onClick = {
                selectedIndex = 1
            }
        )

        BottomNavItem(
            icon = R.drawable.ic_homenavigation_house,
            label = "홈",
            isSelected = selectedIndex == 2,
            onClick = {
                selectedIndex = 2
            }
        )

        BottomNavItem(
            icon = R.drawable.ic_homenavigation_bell,
            label = "이용/알림",
            isSelected = selectedIndex == 3,
            onClick = {
                selectedIndex = 3
            }
        )

        BottomNavItem(
            icon = R.drawable.ic_homenavigation_user,
            label = "내 정보",
            isSelected = selectedIndex == 4,
            onClick = {
                selectedIndex = 4
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}