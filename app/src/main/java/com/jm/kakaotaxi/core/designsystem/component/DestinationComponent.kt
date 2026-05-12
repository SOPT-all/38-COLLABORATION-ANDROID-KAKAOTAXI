package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme.colors

@Composable
fun DestinationItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .size(320.dp, 43.dp)
            .shadow(
                elevation   = 10.dp,
                shape       = RoundedCornerShape(50.dp),
                ambientColor = Color(0x142A2A2A),
                spotColor    = Color(0x142A2A2A),
            )
            .background(colors.white, shape = RoundedCornerShape(50.dp))
            .padding(top = 6.5.dp, bottom = 7.5.dp, start = 14.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_calltaxi_close),
            contentDescription = "닫기",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(18.dp)
        )

        Spacer(modifier = Modifier.width(44.dp))

        Text(
            "우리집",
            style = KakaotaxiTheme.typography.title.kakaoB18,
            color = colors.textPrimary,
        )

        Spacer(modifier = Modifier.width(22.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_calltaxi_arrow),
            contentDescription = "방향",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(24.dp)
        )

        Spacer(modifier = Modifier.width(22.dp))

        Text(
            "한사랑병원",
            style = KakaotaxiTheme.typography.title.kakaoB18,
            color = colors.textPrimary,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoTaxiDestinationItemPreview() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        KakaotaxiTheme {
            DestinationItem()
        }
    }
}