package com.jm.kakaotaxi.presentation.call.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.YesNoButton
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel

@Composable
fun DestinationConfirmContent(
    selectedTaxi: TaxiInfoModel,
    onNoClick: () -> Unit,
    onYesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 21.dp)
            .padding(top = 25.dp, bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_calltaxi_taxi),
            contentDescription = null,
            tint = KakaotaxiTheme.colors.subGray,
            modifier = Modifier
                .size(36.dp)
        )

        Spacer(modifier = Modifier.height(17.dp))

        Text(
            text = "승례님, 집에서 한사랑 병원으로\n가는 택시를 부를까요?",
            style = KakaotaxiTheme.typography.body.kakaoB16,
            color = KakaotaxiTheme.colors.textPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(47.dp))

        YesNoButton(
            onNoClick = onNoClick,
            onYesClick = onYesClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DestinationConfirmContentPreview() {
    KakaotaxiTheme() {
        DestinationConfirmContent(
            selectedTaxi = TaxiInfoModel(
                id = 1,
                taxiImage = R.drawable.img_calltaxi_safetaxi,
                taxiType = "안심 택시",
                taxiDescription = "친절한 기사님\n바로 배차 보장",
                taxiPrice = "7,800"
            ),
            onNoClick = {},
            onYesClick = {}
        )
    }
}