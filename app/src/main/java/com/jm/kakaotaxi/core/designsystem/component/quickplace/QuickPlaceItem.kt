package com.jm.kakaotaxi.core.designsystem.component.quickplace

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun QuickPlaceItem(
    place: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = place,
            color = if (place == "집") KakaotaxiTheme.colors.primaryBlue
                    else KakaotaxiTheme.colors.textSecondary,
            style = KakaotaxiTheme.typography.body.kakaoB16
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickPlaceItemPreview(){
    Column(){
        QuickPlaceItem(
            place = "집",
            icon = R.drawable.ic_home
        )

        Spacer(modifier = Modifier.height(10.dp))

        QuickPlaceItem(
            place = "한사랑병원",
            icon = R.drawable.ic_hospital
        )
    }
}