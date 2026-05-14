package com.jm.kakaotaxi.presentation.home.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
fun NoticeSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "공지",
            style = KakaotaxiTheme.typography.body.kakaoB14,
            color = KakaotaxiTheme.colors.black
        )

        Spacer(modifier = Modifier.weight(1f))

        VerticalDivider(
            modifier = Modifier
                .height(11.dp),
            thickness = 1.dp,
            color = KakaotaxiTheme.colors.backgroundGray
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "[이벤트] 카카오 T 멤버스 5월 쿠폰 이벤트!",
            style = KakaotaxiTheme.typography.body.kakaoR13,
            color = KakaotaxiTheme.colors.black
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_home_notice_more),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 7.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NoticeSectionPreview() {
    NoticeSection()
}