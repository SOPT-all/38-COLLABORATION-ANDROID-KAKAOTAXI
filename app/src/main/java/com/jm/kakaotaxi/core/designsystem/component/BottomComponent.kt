package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KakaotaxiBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    bottomSheetState: SheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    ),
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = bottomSheetState,
        sheetMaxWidth = Dp.Unspecified,
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
        ),
        containerColor = colors.white,
        scrimColor = colors.subGray2,
        dragHandle = { CustomDragHandle() },
        content = content
    )
}

@Composable
private fun CustomDragHandle(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(vertical = 8.dp)
            .size(width = 44.dp, height = 4.dp)
            .background(
                color = colors.subGray2,
                shape = RoundedCornerShape(28.0.dp)
            ),
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun KakaoTaxiBottomSheetPreview() {
    KakaotaxiTheme {
        KakaotaxiBottomSheet(
            onDismissRequest = {},
        ) {
            Spacer(modifier = Modifier.height(300.dp))
        }
    }
}
