package com.jm.kakaotaxi.presentation.call

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiBottomSheet
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import com.jm.kakaotaxi.presentation.call.component.DestinationConfirmContent
import com.jm.kakaotaxi.presentation.call.component.DestinationItem
import com.jm.kakaotaxi.presentation.call.component.TaxiSelectContent
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun CallRoute(
    modifier: Modifier = Modifier,
    viewModel: CallViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CallScreen(
        taxiInfo = uiState.taxiInfo,
        selectedTaxi = uiState.selectedTaxi,
        onServiceChange = viewModel::onTaxiSelected
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CallScreen(
    taxiInfo: ImmutableList<TaxiInfoModel>,
    selectedTaxi: TaxiInfoModel?,
    onServiceChange: (TaxiInfoModel) -> Unit,
    modifier: Modifier = Modifier
) {
    var bottomSheetStep by remember { mutableStateOf(0) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_calltaxi_map),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        
        DestinationItem(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(start = 20.dp, top = 44.dp, end = 20.dp)
        )

        if (bottomSheetStep == 1) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x66000000))
            )
        }

        KakaoTaxiBottomSheet(
            onDismissRequest = {},
            showScrim = false
        ) {
            when (bottomSheetStep) {
                0 -> TaxiSelectContent(
                    taxiInfo = taxiInfo,
                    selectedTaxi = selectedTaxi,
                    onServiceChange = onServiceChange,
                    onCallClick = { bottomSheetStep++ }
                )
                1 -> DestinationConfirmContent(
                    selectedTaxi = selectedTaxi,
                    onNoClick = { bottomSheetStep-- },
                    onYesClick = { bottomSheetStep++ }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CallScreenPreview() {
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

    KakaotaxiTheme {
        CallScreen(
            taxiInfo = taxiServices,
            selectedTaxi = selectedTaxi,
            onServiceChange = { selectedTaxi = it },
        )
    }
}
