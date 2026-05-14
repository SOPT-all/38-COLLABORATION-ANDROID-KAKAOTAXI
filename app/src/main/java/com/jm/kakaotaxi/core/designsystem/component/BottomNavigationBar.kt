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
    items: List<BottomNavType>,
    selectedItem: BottomNavType,
    onItemSelected: (BottomNavType) -> Unit,
    modifier: Modifier = Modifier

){
    Row(
        modifier = Modifier
            .fillMaxWidth()
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
        items.forEach {item->

            val isSelected = item == selectedItem

            BottomNavItem(
                icon = if (isSelected) item.selectedIconRes else item.unselectedIconRes,
                label = item. label,
                isSelected = isSelected,
                onClick = {onItemSelected(item)}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationBarPreview() {

    var selectedItem by remember {
        mutableStateOf(BottomNavType.MENU)
    }

    val items = BottomNavType.entries

    KakaotaxiTheme {
        BottomNavigationBar(
            items = items,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }
        )
    }
}