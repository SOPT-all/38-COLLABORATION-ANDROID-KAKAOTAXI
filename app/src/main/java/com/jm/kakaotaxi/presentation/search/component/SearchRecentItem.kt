package com.jm.kakaotaxi.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.jm.kakaotaxi.core.extensions.noRippleClickable

@Composable
fun SearchRecentItem(
    place: String,
    time: String,
    location: String,
    onRecentItemClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            //.aspectRatio(152f/102f)
            .clip(RoundedCornerShape(10.dp))
            .background(color = KakaotaxiTheme.colors.white)
            .border(
                width = 1.dp,
                color = KakaotaxiTheme.colors.backgroundGray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(top = 14.dp, bottom = 8.dp)
            .padding(horizontal = 15.dp)
            .noRippleClickable(onClick = onRecentItemClick),
    ) {
        Text(
            text = place,
            color = KakaotaxiTheme.colors.textPrimary,
            style = KakaotaxiTheme.typography.body.kakaoB16,
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = time,
            color = KakaotaxiTheme.colors.textSecondary,
            style = KakaotaxiTheme.typography.label.kakaoR12,
        )

        Spacer(modifier = Modifier.height(10.dp))

        RecentLocationChip(
            location = location,
        )
    }
}

@Composable
private fun RecentLocationChip(
    location: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = KakaotaxiTheme.colors.backgroundGray,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(vertical = 4.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_location),
            contentDescription = null,
            modifier = Modifier.size(width = 13.dp, height = 15.dp),
            tint = KakaotaxiTheme.colors.subGray
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            text = location,
            color = KakaotaxiTheme.colors.textSecondary,
            style = KakaotaxiTheme.typography.label.kakaoR12,
        )
    }
}

@Preview
@Composable
private fun SearchRecentItemPreview() {
    KakaotaxiTheme{
        SearchRecentItem(
            place = "한사랑병원",
            time = "오늘 오전",
            location = "송파구",
            onRecentItemClick = {},
        )
    }
}
