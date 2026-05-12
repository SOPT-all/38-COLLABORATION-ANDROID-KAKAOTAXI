package com.jm.kakaotaxi.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.search.type.SearchHistoryType

@Composable
fun SearchHistoryItem(
    type: SearchHistoryType,
    place: String,
    address: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = KakaotaxiTheme.colors.white)
            .padding(bottom = 8.dp, end = 10.dp),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    color = KakaotaxiTheme.colors.backgroundGray2,
                )
                .padding(6.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(type.icon),
                contentDescription = null,
                modifier = Modifier.size(22.dp),
                tint = KakaotaxiTheme.colors.subGray,
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        Column {
            Text(
                text = place,
                color = KakaotaxiTheme.colors.textPrimary,
                style = KakaotaxiTheme.typography.body.kakaoB16,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = address,
                color = KakaotaxiTheme.colors.textSecondary,
                style = KakaotaxiTheme.typography.label.kakaoR12,
            )
        }

        if (type == SearchHistoryType.MAP) {
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_map),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clip(CircleShape)
                    .background(
                        color = KakaotaxiTheme.colors.white
                    )
                    .border(
                        width = 1.dp,
                        color = KakaotaxiTheme.colors.backgroundGray2,
                        shape = CircleShape,
                    )
                    .padding(8.dp),
                tint = KakaotaxiTheme.colors.subGray,
            )
        }
    }
}


@Preview
@Composable
private fun SearchHistoryItemPreview() {
    KakaotaxiTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            SearchHistoryItem(
                type = SearchHistoryType.MAP,
                place = "한사랑병원 응급실",
                address = "서울 송파구 올림픽로 43길 88"
            )

            Spacer(modifier = Modifier.height(10.dp))

            SearchHistoryItem(
                type = SearchHistoryType.DIRECT,
                place = "근처 약국",
                address = "직접 검색하셨어요."
            )
        }
    }
}
