package com.jm.kakaotaxi.presentation.call

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiBottomSheet
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import com.jm.kakaotaxi.presentation.call.component.TaxiItemGrid
import com.jm.kakaotaxi.presentation.call.component.taxiServices
import kotlin.math.max

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
    var selectedService by remember { mutableStateOf(taxiServices.first()) }

    Box(
        modifier = modifier.fillMaxSize()
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
                    .heightIn(max = 450.dp)
                    .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "원하는 택시를 골라주세요",
                    style = KakaotaxiTheme.typography.body.kakaoB16,
                    color = KakaotaxiTheme.colors.textPrimary,
                )

                Spacer(modifier = Modifier.height(9.dp))

                TaxiItemGrid(
                    services = taxiServices,
                    service = selectedService,
                    onServiceChange = { selectedService = it }
                )

                Spacer(modifier = Modifier.height(13.dp))

                Image(
                    painter = painterResource(R.drawable.img_calltaxi_coupon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row() {
                    Text(
                        text = "예상 요금",
                        style = KakaotaxiTheme.typography.body.kakaoR14,
                        color = KakaotaxiTheme.colors.textSecondary,
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "7,800원",
                        style = KakaotaxiTheme.typography.title.kakaoB20,
                        color = KakaotaxiTheme.colors.textPrimary
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))


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
