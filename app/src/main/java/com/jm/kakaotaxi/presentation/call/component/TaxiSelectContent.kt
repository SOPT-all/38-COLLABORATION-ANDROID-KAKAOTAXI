package com.jm.kakaotaxi.presentation.call.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.ButtonItem
import com.jm.kakaotaxi.core.designsystem.component.ButtonStyle
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme.colors
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun TaxiSelectContent(
    taxiInfo: ImmutableList<TaxiInfoModel>,
    selectedTaxi: TaxiInfoModel?,
    onServiceChange: (TaxiInfoModel) -> Unit,
    onCallClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .heightIn(max = 450.dp)
            .padding(top = 10.dp, bottom = 22.dp, start = 20.dp, end = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "원하는 택시를 골라주세요",
            style = KakaotaxiTheme.typography.body.kakaoB16,
            color = colors.textPrimary,
        )

        Spacer(modifier = Modifier.height(9.dp))

        TaxiItemGrid(
            services = taxiInfo,
            service = selectedTaxi ?: taxiInfo.first(),
            onServiceChange = onServiceChange
        )

        Spacer(modifier = Modifier.height(13.dp))

        Image(
            painter = painterResource(R.drawable.img_calltaxi_coupon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "예상 요금",
                style = KakaotaxiTheme.typography.body.kakaoR14,
                color = colors.textSecondary,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = colors.black)) {
                        append("예상 ${selectedTaxi?.taxiPrice}")
                    }
                    withStyle(SpanStyle(color = colors.textSecondary)) {
                        append("원")
                    }
                },
                style = KakaotaxiTheme.typography.body.kakaoB16,
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        ButtonItem(
            text = "택시 부르기",
            style = ButtonStyle.CALL,
            onClick = {
                // TODO: 버튼 클릭되면 taxiId 서버에 넘기기
                onCallClick()
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TaxiSelectContentPreview() {
    KakaotaxiTheme() {
        val taxiServices = persistentListOf(
            TaxiInfoModel(
                id = 1,
                taxiImage = R.drawable.img_calltaxi_safetaxi,
                taxiType = "안심 택시",
                taxiDescription = "친절한 기사님\n바로 배차 보장",
                taxiPrice = "7,800",
            ),
            TaxiInfoModel(
                id = 2,
                taxiImage = R.drawable.img_calltaxi_gentaxi,
                taxiType = "일반 택시",
                taxiDescription = "가장 빠르게\n주변 택시 연결",
                taxiPrice = "4,800",
            ),
            TaxiInfoModel(
                id = 3,
                taxiImage = R.drawable.img_calltaxi_greattaxi,
                taxiType = "모범 택시",
                taxiDescription = "고급 차량\n베테랑 기사님",
                taxiPrice = "10,000",
            ),
            TaxiInfoModel(
                id = 4,
                taxiImage = R.drawable.img_calltaxi_bigtaxi,
                taxiType = "대형 택시",
                taxiDescription = "넓은 좌석\n짐이 많을 때",
                taxiPrice = "13,000",
            )
        )
        var selectedTaxi by remember { mutableStateOf(taxiServices.first()) }

        TaxiSelectContent(
            taxiInfo = taxiServices,
            selectedTaxi = selectedTaxi,
            onServiceChange = { selectedTaxi = it },
            onCallClick = {}
        )
    }
}