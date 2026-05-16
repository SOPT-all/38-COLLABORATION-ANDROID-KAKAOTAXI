package com.jm.kakaotaxi.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.data.model.home.FavoriteServiceModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun FavoriteSection(
    services: ImmutableList<FavoriteServiceModel>,
    onStarClick: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
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

        Spacer(modifier = Modifier.height(9.dp))

        Image(
            painter = painterResource(R.drawable.img_home_point_taxi),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(2f / 3f)
        )

        Spacer(modifier = Modifier.height(9.dp))

        FavoriteServiceGrid(
            services = services,
            onStarClick = onStarClick,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "전체 서비스 보기",
            modifier = Modifier
                .fillMaxWidth(),
            color = KakaotaxiTheme.colors.textSecondary,
            textAlign = TextAlign.Center,
            style = KakaotaxiTheme.typography.body.kakaoB16
        )

        Spacer(modifier = Modifier.height(9.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun FavoriteSectionPreview() {
    val fakeFavoriteServices = persistentListOf(
        FavoriteServiceModel(
            id = 1,
            title = "택시",
            subtitle = "바로 이동해볼까요?",
            carImage = R.drawable.img_home_taxi
        ),
        FavoriteServiceModel(
            id = 2,
            title = "택시 예약",
            subtitle = "미리 예약해볼까요?",
            carImage = R.drawable.img_home_taxi_reservation
        ),
        FavoriteServiceModel(
            id = 3,
            title = "기차/버스",
            subtitle = "교통편을 찾아볼까요?",
            carImage = R.drawable.img_home_train_bus
        ),
        FavoriteServiceModel(
            id = 4,
            title = "렌터카",
            subtitle = "차를 빌려볼까요?",
            carImage = R.drawable.img_home_rental_car
        )
    )

//    KakaotaxiTheme {
//        FavoriteSection(
//            services = fakeFavoriteServices,
//            isStarClicked = false,
//            onStarClick = {}
//        )
//    }
}
