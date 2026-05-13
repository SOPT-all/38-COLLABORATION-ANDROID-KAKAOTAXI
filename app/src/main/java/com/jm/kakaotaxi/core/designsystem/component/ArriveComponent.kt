package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme


@Composable
fun ArriveItem(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp),
        ){
            Box(
              modifier = Modifier
                  .background(KakaotaxiTheme.colors.backgroundGray2)
                  .size(width = 268.dp, height = 42.dp)
                  .border(1.dp, color = KakaotaxiTheme.colors.backgroundGray)
                  .padding(start = 16.dp)
            ){
                Row(modifier = Modifier.fillMaxSize())
                {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrivescreen_check),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        "천천히 탑승하실 수 있도록 전달해요!",
                        style = KakaotaxiTheme.typography.body.kakaoR14,
                        color = KakaotaxiTheme.colors.textSecondary
                    )

                    Spacer(modifier = Modifier.width(7.dp))


                }
            }
        }
}