package com.jm.kakaotaxi.presentation.call.component

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.call.TaxiInfoModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun TaxiItemGrid(
    taxiItems: ImmutableList<TaxiInfoModel>,
    taxiItem: TaxiInfoModel,
    onTaxiItemChange: (TaxiInfoModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = spacedBy(12.dp)
    ) {
        taxiItems.chunked(2).forEach { items ->
            Row(
                horizontalArrangement = spacedBy(12.dp)
            ) {
                items.forEach { item ->
                    SelectTaxiItem(
                        item = item,
                        onItemClick = {onTaxiItemChange(item)},
                        isSelected = taxiItem == item,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TaxiItemGridPreview() {
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

    TaxiItemGrid(
        taxiItems = taxiServices,
        taxiItem = taxiServices.first(),
        onTaxiItemChange = {}
    )
}