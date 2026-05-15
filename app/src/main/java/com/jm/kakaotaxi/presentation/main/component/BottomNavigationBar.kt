package com.jm.kakaotaxi.presentation.main.component

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
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun BottomNavigationBar(
    items: ImmutableList<BottomNavType>,
    selectedItem: BottomNavType,
    onItemSelected: (BottomNavType) -> Unit,
    modifier: Modifier = Modifier

){
    Row(
        modifier = modifier
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
            BottomNavItem(
                icon = if (item == selectedItem) item.selectedIconRes else item.unselectedIconRes,
                label = item. label,
                isSelected = item == selectedItem,
                onClick = {onItemSelected(item)},
                modifier = Modifier.weight(1f)

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

    val items = BottomNavType.entries.toImmutableList()

    KakaotaxiTheme {
        BottomNavigationBar(
            items = items,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }
        )
    }
}