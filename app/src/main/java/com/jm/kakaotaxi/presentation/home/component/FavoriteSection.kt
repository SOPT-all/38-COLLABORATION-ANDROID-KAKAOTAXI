package com.jm.kakaotaxi.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.data.model.FavoriteServiceModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun FavoriteSection(
    services: ImmutableList<FavoriteServiceModel>,
    onStarClick: (FavoriteServiceModel) -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "자주 쓰는 서비스",
            color = KakaotaxiTheme.colors.textPrimary,
            style = KakaotaxiTheme.typography.body.kakaoB16
        )

        Text(
            text = "편집",
            color = KakaotaxiTheme.colors.textSecondary,
            style = KakaotaxiTheme.typography.body.kakaoB14
        )
    }

    Image(
        painter = painterResource(R.drawable.img_home_point_taxi),
        contentDescription = null,
        modifier = Modifier
    )

    FavoriteServiceGrid(
        services = services,
        onStarClick = onStarClick
    )

    Text(
        text = "전체 서비스 보기",
        color = KakaotaxiTheme.colors.textSecondary,
        textAlign = TextAlign.Center,
        style = KakaotaxiTheme.typography.body.kakaoB16,
    )

}