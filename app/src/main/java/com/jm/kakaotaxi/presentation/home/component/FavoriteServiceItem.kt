package com.jm.kakaotaxi.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun FavoriteServiceItem(
    title: String,
    subtitle: String,
    @DrawableRes starIcon: Int,
    @DrawableRes carImage: Int,
    onStarClick: () -> Unit,
    onServiceClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(KakaotaxiTheme.colors.white)
            .border(
                width = 1.dp,
                color = KakaotaxiTheme.colors.backgroundGray,
                shape = RoundedCornerShape(10.dp)
            )
            .noRippleClickable(onClick = onServiceClick)
    ) {
        Column (
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
        ){
            Text(
                text = title,
                color = KakaotaxiTheme.colors.textPrimary,
                style = KakaotaxiTheme.typography.body.kakaoB16
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = subtitle,
                color = KakaotaxiTheme.colors.textSecondary,
                style = KakaotaxiTheme.typography.label.kakaoR12
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(starIcon),
            contentDescription = null,
            modifier = Modifier
                .align (Alignment.TopEnd)
                .padding(end = 15.dp, top = 15.dp)
                .noRippleClickable(onClick = onStarClick),
            tint = Color.Unspecified,
        )

        Image(
            painter = painterResource(carImage),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun FavoriteServiceItemPreview() {
    FavoriteServiceItem(
        title = "택시",
        subtitle = "바로 이동해볼까요?",
        starIcon = R.drawable.ic_home_star_gray,
        carImage = R.drawable.img_home_taxi,
        onStarClick = {},
        onServiceClick = {},
    )
}