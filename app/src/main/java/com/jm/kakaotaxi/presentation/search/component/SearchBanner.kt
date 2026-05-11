package com.jm.kakaotaxi.presentation.search.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun SearchBanner(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = KakaotaxiTheme.colors.backgroundGray2,
            )
            .padding(11.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.img_search_banner),
            contentDescription = null,
            modifier = Modifier
                .width(92.dp)
                .aspectRatio(92f / 60f)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.padding(vertical = 3.dp),
        ) {
            Text(
                text = "무거운 장보기 짐, 대신 배달",
                color = KakaotaxiTheme.colors.textPrimary,
                style = KakaotaxiTheme.typography.body.kakaoB16,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "탑마트 성수점 쇼핑 후, 택시 대신 신선 배송 서비스를\n이용해보세요!",
                color = KakaotaxiTheme.colors.subGray,
                style = KakaotaxiTheme.typography.label.kakaoR8,
            )
        }

        Spacer(modifier = Modifier.width(7.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_info),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = Color.Unspecified,
        )
    }
}

@Preview
@Composable
private fun SearchAdBannerPreview() {
    KakaotaxiTheme {
        SearchBanner()
    }
}
