package com.jm.kakaotaxi.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme.colors
import com.jm.kakaotaxi.core.extensions.noRippleClickable

@Composable
fun SelectTaxiItem(
    modifier: Modifier = Modifier,
    id: Int,
    isSelected: Boolean = false,
    onItemClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(colors.white)
            .border(
                width = 1.dp,
                color = if (isSelected) colors.pointYellow else colors.backgroundGray,
                shape = RoundedCornerShape(10.dp)
            )
            .noRippleClickable(onClick = onItemClick)
            .padding(top = 10.dp, end = 8.dp)
    ) {
        TaxiInfo(
            taxiImage = R.drawable.img_calltaxi_bigtaxi,
            taxiType = "대형 택시",
            taxiDescription = "넓은 좌석\n" +
                    "짐이 많을 때",
            taxiPrice = "13000"
        )

        Icon(
            imageVector = ImageVector.vectorResource(
                if (isSelected) R.drawable.ic_calltaxi_selected_yellow
                else R.drawable.ic_calltaxi_default_grey
            ),
            contentDescription = if (isSelected) "선택됨" else "선택 안됨",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.TopEnd)
        )
    }
}

@Composable
private fun TaxiInfo(
    @DrawableRes
    taxiImage: Int,
    taxiType: String,
    taxiDescription: String,
    taxiPrice: String,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(start = 21.dp, end = 29.dp, bottom = 13.dp)
    ) {
        Image(
            painter = painterResource(taxiImage),
            contentDescription = null,
            modifier = Modifier
                .width(97.dp)
                .aspectRatio(97f/ 62f),
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = taxiType,
            style = KakaotaxiTheme.typography.body.kakaoB16,
            color = colors.textPrimary,
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = taxiDescription,
            style = KakaotaxiTheme.typography.label.kakaoR12,
            color = colors.textSecondary,
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "예상 "+ taxiPrice + "원",
            style = KakaotaxiTheme.typography.body.kakaoB16,
            color = colors.black
            // "원"은 textSecondary
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoTaxiSelectTaxiItemPreview() {
    KakaotaxiTheme {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            SelectTaxiItem(
                isSelected = true,
                onItemClick = {},
            )

            Spacer(modifier = Modifier.height(10.dp))

            SelectTaxiItem(
                isSelected = false,
                onItemClick = {},
            )
        }
    }
}