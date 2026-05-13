package com.jm.kakaotaxi.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.extensions.noRippleClickable

@Composable
fun BottomNavItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(
                    color = KakaotaxiTheme.colors.white
                )
                .noRippleClickable(onClick = onClick)
                .padding(vertical = 10.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = icon),
                contentDescription = label,
                tint = if (isSelected) KakaotaxiTheme.colors.primaryBlue else Color. Unspecified
            )

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = label,
                style = if (isSelected) {
                    KakaotaxiTheme.typography.label.kakaoB10
                } else {
                    KakaotaxiTheme.typography.label.kakaoR10
                },
                color = if (isSelected) {
                    KakaotaxiTheme.colors.primaryBlue
                } else {
                    KakaotaxiTheme.colors.textPrimary
                }
            )
        }

    }

@Preview(showBackground = true)
@Composable
private fun BottomNavItemSelectedPreview() {
    KakaotaxiTheme {
        BottomNavItem(
            icon = R.drawable.ic_homenavigation_menu,
            label = "전체보기",
            isSelected = true,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavItemUnselectedPreview() {
    KakaotaxiTheme {
        BottomNavItem(
            icon = R.drawable.ic_homenavigation_menu,
            label = "전체보기",
            isSelected = false,
            onClick = {}
        )
    }
}