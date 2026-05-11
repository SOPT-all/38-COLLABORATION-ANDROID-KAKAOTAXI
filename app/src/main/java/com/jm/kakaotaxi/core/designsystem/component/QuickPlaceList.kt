package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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


@Composable
fun QuickPlaceList(
    places: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ){
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(23.dp)
        ) {
            QuickItems(
                place = places[0],
                icon = R.drawable.ic_home,
                color = KakaotaxiTheme.colors.primaryBlue
            )

            QuickItems(
                place = places[1],
                icon = R.drawable.ic_hospital
            )

            QuickItems(
                place = places[2],
                icon = R.drawable.ic_building
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_plus),
                contentDescription = null,
                tint = KakaotaxiTheme.colors.textSecondary
            )
        }

        Box(
            modifier = Modifier
                .height(1.5.dp)
                .width(310.dp)
                .background(KakaotaxiTheme.colors.backgroundGray)
        )
    }
}

private val dummyPlaces = listOf(
    "집", "한사랑병원", "노인정"
)

@Preview(showBackground = true)
@Composable
private fun QuickPlaceListPreview() {
    QuickPlaceList(
        places = dummyPlaces
    )
}