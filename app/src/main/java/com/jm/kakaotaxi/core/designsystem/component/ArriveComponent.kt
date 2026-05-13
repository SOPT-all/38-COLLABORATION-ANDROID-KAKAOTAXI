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
fun ArriveItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 21.dp),
    ) {
        //요청 박스
        Box(
            modifier = Modifier
                .weight(1f)
                .height(42.dp)
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray2
                )
                .border(
                    1.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp)
            ) {
                Icon(
                    modifier = Modifier.padding(vertical = 9.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrivescreen_checkcircle),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(9.dp))

                Text(
                    modifier = Modifier.padding(vertical = 11.dp),
                    text = "천천히 탑승하실 수 있도록 전달해요!",
                    style = KakaotaxiTheme.typography.body.kakaoR14,
                    color = KakaotaxiTheme.colors.textSecondary
                )
            }
        }

        Spacer(modifier = Modifier.width(7.dp))
        //전화 버튼
        Box(
            modifier = Modifier
                .size(43.dp)
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray2
                )
                .border(
                    1.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = KakaotaxiTheme.colors.backgroundGray
                )
                .padding(
                    start = 10.dp,
                    top = 10.dp,
                    end = 9.dp,
                    bottom = 9.dp
                ),
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
fun ArriveItemPreview() {
    KakaotaxiTheme {
        ArriveItem()
    }
}