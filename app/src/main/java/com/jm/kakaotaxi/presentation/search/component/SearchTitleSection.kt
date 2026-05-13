package com.jm.kakaotaxi.presentation.search.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun SearchTitleSection(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Column {
            Text(
                text = title,
                color = KakaotaxiTheme.colors.textPrimary,
                style = KakaotaxiTheme.typography.body.kakaoB16,
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = subtitle,
                color = KakaotaxiTheme.colors.textSecondary,
                style = KakaotaxiTheme.typography.label.kakaoR12,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "전체보기",
            color = KakaotaxiTheme.colors.textSecondary,
            style = KakaotaxiTheme.typography.body.kakaoB14,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun SearchTitleSectionPreview() {
    KakaotaxiTheme {
        SearchTitleSection(
            title = "최근에 간 곳",
            subtitle = "눌러서 바로 택시를 부를 수 있어요"
        )
    }
}
