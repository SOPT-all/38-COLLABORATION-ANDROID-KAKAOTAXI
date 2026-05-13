package com.jm.kakaotaxi.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.FavoriteServiceModel
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun FavoriteServiceGrid(
    services: ImmutableList<FavoriteServiceModel>
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        items(services) { service ->
            FavoriteServiceItem(
                title = service.title,
                subtitle = service.subtitle,
                starIcon = service.starIcon,
                carImage = service.carImage
            )
        }
    }
}

val favoriteServices = persistentListOf(
    FavoriteServiceModel(
        title = "택시",
        subtitle = "바로 이동해볼까요?",
        starIcon = R.drawable.ic_home_star_yellow,
        carImage = R.drawable.img_home_taxi
    ),
    FavoriteServiceModel(
        title = "택시 예약",
        subtitle = "미리 예약해볼까요?",
        carImage = R.drawable.img_home_taxi_reseravation
    ),
    FavoriteServiceModel(
        title = "기차/버스",
        subtitle = "교통편을 찾아볼까요?",
        carImage = R.drawable.img_home_train_bus
    ),
    FavoriteServiceModel(
        title = "렌터",
        subtitle = "차를 빌려볼까요?",
        carImage = R.drawable.img_home_rental_car
    )
)

@Preview
@Composable
private fun FavoriteServiceGridPreview(){
    FavoriteServiceGrid(favoriteServices)
}