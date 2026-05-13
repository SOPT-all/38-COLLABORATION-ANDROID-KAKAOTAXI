package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun BottomNavigationBar(
    selectedIndex: Int,
    onSelectedChange: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
            .background(
                color = KakaotaxiTheme.colors.white,
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 29.dp
                )
            )
            .padding(horizontal = 25.dp)
            .padding(top = 8.dp, bottom = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ){
        BottomNavItem(
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_homenavigation_menu,
            label = "전체보기",
            isSelected = selectedIndex == 0,
            onClick = {
                onSelectedChange (0)
            }
        )

        BottomNavItem(
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_homenavigation_business,
            label = "비즈니스",
            isSelected = selectedIndex == 1,
            onClick = {
                onSelectedChange(1)
            }
        )

        BottomNavItem(
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_homenavigation_house,
            label = "홈",
            isSelected = selectedIndex == 2,
            onClick = {
                onSelectedChange(2)
            }
        )

        BottomNavItem(
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_homenavigation_bell,
            label = "이용/알림",
            isSelected = selectedIndex == 3,
            onClick = {
                onSelectedChange(3)
            }
        )

        BottomNavItem(
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_homenavigation_user,
            label = "내 정보",
            isSelected = selectedIndex == 4,
            onClick = {
                onSelectedChange(4)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationBarPreview() {
         var selectedIndex by remember {
        mutableStateOf(0)
        }
    BottomNavigationBar(
        selectedIndex = selectedIndex,
        onSelectedChange = {
            selectedIndex = it
        }
    )
}