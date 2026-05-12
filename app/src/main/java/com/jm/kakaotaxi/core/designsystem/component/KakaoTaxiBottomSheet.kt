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
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KakaoTaxiBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    bottomSheetState: SheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { targetValue ->
            targetValue != SheetValue.Hidden
        }
    ),
    showScrim: Boolean = true,
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = bottomSheetState,
        sheetMaxWidth = Dp.Unspecified,
        shape = RoundedCornerShape(
            topStart = 24.dp,
            topEnd = 24.dp,
            ),
        containerColor = colors.white,
        scrimColor = if (showScrim) Color(0x66000000) else Color.Transparent,
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
            .padding(top = 8.dp, bottom = 12.dp)
            .size(width = 44.dp, height = 4.dp)
            .background(
                color = colors.subGray2,
                shape = RoundedCornerShape(4.dp)
            ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun KakaoTaxiBottomSheetPreview() {
    KakaotaxiTheme {
        KakaoTaxiBottomSheet(
            onDismissRequest = {},
            showScrim = false
        ) {
            Spacer(modifier = Modifier.height(300.dp))
        }
    }
}