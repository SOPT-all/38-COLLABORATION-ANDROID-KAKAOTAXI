package com.jm.kakaotaxi.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun EventSection(){
    Text(
        text = "이벤트/새소식",
        color = KakaotaxiTheme.colors.textPrimary,
        style = KakaotaxiTheme.typography.body.kakaoB16
    )

    Image(
        painter = painterResource(R.drawable.img_home_event_banner),
        contentDescription = null,
        modifier = Modifier
    )
}