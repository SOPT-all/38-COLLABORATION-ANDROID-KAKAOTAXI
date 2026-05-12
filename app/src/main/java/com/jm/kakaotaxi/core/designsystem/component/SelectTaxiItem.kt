package com.jm.kakaotaxi.core.designsystem.component

import android.R.attr.contentDescription
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    isSelected: Boolean = false,
    onItemClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(colors.white)
            .then(
                if (isSelected) {
                    Modifier.border(
                        width = 1.dp,
                        color = colors.pointYellow,
                    )
                } else Modifier.border(
                    width = 1.dp,
                    color = colors.backgroundGray
                )
            )
            .noRippleClickable(onClick = onItemClick)
            .padding(top = 10.dp, end = 8.dp)
    ) {
        Column(
            // 택시 이미지
            // 택시 이름
            // 택시 특징
            // 예상 금액
        ) {

        }
        if (isSelected) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_calltaxi_selected_yellow),
                contentDescription = "선택됨",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.TopEnd)
            )
        } else Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_calltaxi_default_grey),
            contentDescription = "선택 안됨",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.TopEnd)
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