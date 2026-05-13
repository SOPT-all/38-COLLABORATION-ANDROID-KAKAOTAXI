package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme


@Composable
fun ArriveItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 21.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray2
                )
                .border(
                    1.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray
                )
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrivescreen_checkcircle),
                contentDescription = null,
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "천천히 탑승하실 수 있도록 전달해요!",
                modifier = Modifier.padding(vertical = 7.dp),
                style = KakaotaxiTheme.typography.body.kakaoR14,
                color = KakaotaxiTheme.colors.textSecondary
            )
        }

        Spacer(modifier = Modifier.width(7.dp))
        //전화 버튼
        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray2
                )
                .border(
                    1.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray
                )
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrivescreen_phone),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ArriveItemPreview() {
    KakaotaxiTheme {
        ArriveItem()
    }
}