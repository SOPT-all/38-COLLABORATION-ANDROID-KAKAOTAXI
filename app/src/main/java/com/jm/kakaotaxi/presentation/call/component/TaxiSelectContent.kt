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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.ButtonItem
import com.jm.kakaotaxi.core.designsystem.component.ButtonStyle
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme.colors
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun TaxiSelectContent(
    taxiInfo: ImmutableList<TaxiInfoModel>,
    selectedTaxi: TaxiInfoModel?,
    onServiceChange: (TaxiInfoModel) -> Unit,
    onCallClick: () -> Unit,
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

        Row {
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