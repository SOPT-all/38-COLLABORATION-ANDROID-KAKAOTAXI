package com.jm.kakaotaxi.presentation.call

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiBottomSheet
import com.jm.kakaotaxi.presentation.call.component.TaxiItemGrid
import com.jm.kakaotaxi.presentation.call.component.taxiServices

@Composable
fun CallRoute(
    modifier: Modifier = Modifier
) {
    CallScreen(
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CallScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_calltaxi_map),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        KakaoTaxiBottomSheet(
            onDismissRequest = {},
            showScrim = false
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "원하는 택시를 골라주세요",
                    style = KakaotaxiTheme.typography.body.kakaoB16,
                    color = KakaotaxiTheme.colors.textPrimary,
                )

                Spacer(modifier = Modifier.height(9.dp))

                TaxiItemGrid(
                    services = taxiServices,
                    service = taxiServices.first(),
                )

                Spacer(modifier = Modifier.height(13.dp))


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CallScreenPreview() {
    KakaotaxiTheme {
        CallScreen()
    }
}
