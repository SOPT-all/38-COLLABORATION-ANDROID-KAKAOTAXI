package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.extensions.noRippleClickable

@Composable
fun ButtonItem(
    text: String,
    backgroundColor: Color,
    contentColor: Color,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(10.dp)
            )
            .noRippleClickable(onClick = onClick)
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            style = KakaotaxiTheme.typography.title.kakaoB18,
            color = contentColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonItemPreview() {
    KakaotaxiTheme {

        Row {

           ButtonItem(
               text = "네",
               backgroundColor = KakaotaxiTheme.colors.primaryBlue,
               contentColor = KakaotaxiTheme.colors.white,
               paddingValues = PaddingValues(
                   horizontal = 69.dp,
                   vertical = 10.dp
               ),
               onClick = {}
           )

        }
    }
}