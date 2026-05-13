package com.jm.kakaotaxi.core.designsystem.component.quickplace


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf


@Composable
fun QuickPlaceList(
    places: ImmutableList<QuickPlaceModel>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(KakaotaxiTheme.colors.white)
    ){
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 6.dp),
            contentPadding = PaddingValues(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            items(
                items = places,
                key = { it.id }
            ) { place ->
                QuickPlaceItem(
                    place = place.title,
                    icon = place.icon,
                    color = place.color
                )
            }

            item{
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_pluscircle),
                    contentDescription = null,
                    tint = KakaotaxiTheme.colors.textSecondary
                )
            }
        }

        Spacer(modifier = Modifier.height(7.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = KakaotaxiTheme.colors.backgroundGray
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun QuickPlaceListPreview() {
    KakaotaxiTheme {
        val fakeQuickPlaces = persistentListOf(
            QuickPlaceModel(1, "집", R.drawable.ic_home, KakaotaxiTheme.colors.primaryBlue),
            QuickPlaceModel(2, "한사랑병원", R.drawable.ic_hospital, KakaotaxiTheme.colors.textSecondary),
            QuickPlaceModel(3, "노인정", R.drawable.ic_senior_home, KakaotaxiTheme.colors.textSecondary)
        )
        QuickPlaceList(
            places = fakeQuickPlaces
        )
    }
}