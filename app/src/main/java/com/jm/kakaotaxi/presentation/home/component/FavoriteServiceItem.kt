package com.jm.kakaotaxi.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun FavoriteServiceItem(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    starIcon: Int,
    carImage: Int
) {
    Box(
        modifier = modifier
            .size(150.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(KakaotaxiTheme.colors.white)
            .border(
                width = 1.dp,
                color = KakaotaxiTheme.colors.backgroundGray,
                shape = RoundedCornerShape(12.dp)
            )

    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = title,
                    color = KakaotaxiTheme.colors.textPrimary,
                    style = KakaotaxiTheme.typography.body.kakaoB16
                )

                Icon(
                    painterResource(starIcon),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }

            Text(
                text = subtitle,
                color = KakaotaxiTheme.colors.textSecondary,
                style = KakaotaxiTheme.typography.label.kakaoR12
            )
        }

        Image(
            painter = painterResource(carImage),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview
@Composable
private fun FavoriteServiceItemPreview() {
    FavoriteServiceItem(
        title = "택시",
        subtitle = "바로 이동해볼까요?",
        starIcon = R.drawable.ic_home_star_yellow,
        carImage = R.drawable.img_home_taxi
    )
}