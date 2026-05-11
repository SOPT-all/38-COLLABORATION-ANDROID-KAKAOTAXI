package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.type.SearchBarType
import com.jm.kakaotaxi.core.extensions.noRippleClickable

@Composable
fun KakaoTaxiSearchBar(
    type: SearchBarType,
    onSearchBarClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val isHome = type == SearchBarType.HOME

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(color = KakaotaxiTheme.colors.white)
            .then(
                if (isHome) {
                    Modifier.border(
                        width = 1.5.dp,
                        color = KakaotaxiTheme.colors.primaryBlue,
                        shape = RoundedCornerShape(10.dp),
                    )
                } else Modifier
            )
            .noRippleClickable(onClick = onSearchBarClick)
            .padding(horizontal = 13.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        if (!isHome) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left),
                contentDescription = null,
                modifier = Modifier.size(width = 25.dp, height = 20.dp),
                tint = KakaotaxiTheme.colors.textSecondary,
            )

            Spacer(modifier = Modifier.width(20.dp))
        }

        Text(
            text = "어디로 모실까요?",
            color = KakaotaxiTheme.colors.textSecondary,
            style = if (isHome) KakaotaxiTheme.typography.title.kakaoB20 else KakaotaxiTheme.typography.body.kakaoB14
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_mic),
            contentDescription = null,
            modifier = Modifier.size(34.dp),
            tint = KakaotaxiTheme.colors.textSecondary,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoTaxiSearchBarPreview() {
    KakaotaxiTheme {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            KakaoTaxiSearchBar(
                type = SearchBarType.HOME,
                onSearchBarClick = {},
            )

            Spacer(modifier = Modifier.height(10.dp))

            KakaoTaxiSearchBar(
                type = SearchBarType.SEARCH,
                onSearchBarClick = {},
            )
        }
    }
}
