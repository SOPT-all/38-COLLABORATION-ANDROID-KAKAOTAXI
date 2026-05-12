package com.jm.kakaotaxi.core.designsystem.component.quickplace

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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


@Composable
fun QuickPlaceList(
    places: List<QuickPlaceModel>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(KakaotaxiTheme.colors.white)
    ){
        Row(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 6.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {

            QuickPlaceItem(
                place = places[0].title,
                icon = R.drawable.img_home,
                color = KakaotaxiTheme.colors.primaryBlue
            )

            QuickPlaceItem(
                place = places[1].title,
                icon = R.drawable.img_hospital
            )

            QuickPlaceItem(
                place = places[2].title,
                icon = R.drawable.img_senior_home
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_pluscircle),
                contentDescription = null,
                tint = KakaotaxiTheme.colors.textSecondary
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(top = 7.dp)
                .height(1.dp)
                .fillMaxWidth()
                .background(KakaotaxiTheme.colors.backgroundGray)
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun QuickPlaceListPreview() {
    val fakeQuickPlaces = listOf(
        QuickPlaceModel("집"),
        QuickPlaceModel("한사랑병원"),
        QuickPlaceModel("노인정")
    )

    QuickPlaceList(
        places = fakeQuickPlaces
    )
}