package com.jm.kakaotaxi.core.designsystem.component.quickplace

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun QuickPlaceItem(
    place: String,
    @DrawableRes icon: Int,
    color: Color = KakaotaxiTheme.colors.textSecondary
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = color
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = place,
            color = color,
            style = KakaotaxiTheme.typography.body.kakaoB16
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickPlaceItemPreview(){
    QuickPlaceItem(
        place = "집",
        icon = R.drawable.ic_home,
        color = KakaotaxiTheme.colors.primaryBlue
    )
}