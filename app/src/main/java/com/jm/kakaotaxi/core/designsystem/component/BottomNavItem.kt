package com.jm.kakaotaxi.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun BottomNavItem(
    @DrawableRes icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable{
                    onClick()
                }
                .padding(vertical = 10.dp,horizontal = 12.dp )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                tint = if (isSelected) KakaotaxiTheme.colors.primaryBlue else Color. Unspecified
            )

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = label,
                color = if (isSelected) KakaotaxiTheme.colors.primaryBlue else Color. Unspecified
            )
        }

    }