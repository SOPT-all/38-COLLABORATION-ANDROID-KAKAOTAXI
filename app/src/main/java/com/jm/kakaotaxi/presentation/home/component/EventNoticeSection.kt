package com.jm.kakaotaxi.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun EventNoticeSection(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(top = 34.dp, bottom = 14.dp)
            .padding(horizontal = 24.dp)
    ){
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "이벤트/새소식",
            color = KakaotaxiTheme.colors.textPrimary,
            style = KakaotaxiTheme.typography.body.kakaoB16
        )

        Spacer(modifier = Modifier.height(11.dp))

        Image(
            painter = painterResource(R.drawable.img_home_event_banner),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(14.dp))

        HorizontalDivider(
            thickness = 1.dp,
            color = KakaotaxiTheme.colors.backgroundGray
        )

        Spacer(modifier = Modifier.height(20.dp))

        NoticeSection()
    }
}

@Preview(showBackground = true)
@Composable
private fun EventNoticeSectionPreview(){
    EventNoticeSection()
}