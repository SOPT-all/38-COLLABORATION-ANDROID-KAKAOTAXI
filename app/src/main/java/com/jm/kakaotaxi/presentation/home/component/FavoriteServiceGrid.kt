package com.jm.kakaotaxi.presentation.home.component

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.home.FavoriteServiceModel
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun FavoriteServiceGrid(
    services: ImmutableList<FavoriteServiceModel>,
    onStarClick: () -> Unit,
    isStarClicked: Boolean,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = spacedBy(15.dp)
    ) {
        services.chunked(2).forEach { items ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = spacedBy(12.dp)
            ) {
                items.forEach { service ->
                    FavoriteServiceItem(
                        title = service.title,
                        subtitle = service.subtitle,
                        isStarClicked = isStarClicked,
                        carImage = service.carImage,
                        onStarClick = { onStarClick() },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}



@Preview
@Composable
private fun FavoriteServiceGridPreview(){
    val favoriteServices = persistentListOf(
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

    FavoriteServiceGrid(
        favoriteServices,
        onStarClick = {},
        isStarClicked = false
    )
}