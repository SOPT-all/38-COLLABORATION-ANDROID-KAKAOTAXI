package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KakaoTaxiBottomSheet(
    modifier: Modifier = Modifier,
    showScrim: Boolean = true,
    screenContent: @Composable BoxScope.() -> Unit = {},
    sheetContent: @Composable ColumnScope.() -> Unit,
) {
    var isExpanded by remember { mutableStateOf(true) }
    val navigationBarHeight = WindowInsets.navigationBars
        .asPaddingValues()
        .calculateBottomPadding()

    Box(modifier = modifier.fillMaxSize()) {
        screenContent()

        if (!isExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        color = colors.white,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    )
                    .padding(bottom = navigationBarHeight),
                contentAlignment = Alignment.TopCenter,
            ) {
                CustomDragHandle(
                    modifier = Modifier
                        .clickable { isExpanded = true }
                        .pointerInput(Unit) {
                            detectVerticalDragGestures { _, dragAmount ->
                                if (dragAmount < 0) isExpanded = true
                            }
                        }
                )
            }
        }

        if (isExpanded) {
            ModalBottomSheet(
                onDismissRequest = { isExpanded = false },
                sheetMaxWidth = Dp.Unspecified,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                containerColor = colors.white,
                scrimColor = if (showScrim) Color(0x66000000) else Color.Transparent,
                dragHandle = { CustomDragHandle() },
                content = sheetContent,
            )
        }
    }
}

@Composable
private fun CustomDragHandle(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(top = 8.dp, bottom = 22.dp)
            .size(width = 44.dp, height = 4.dp)
            .background(
                color = colors.subGray2,
                shape = RoundedCornerShape(4.dp),
            ),
    )
}


@Preview(showBackground = true)
@Composable
private fun KakaoTaxiBottomSheetPreview() {
    KakaotaxiTheme {
        KakaoTaxiBottomSheet(showScrim = true) {
            Spacer(modifier = Modifier.height(300.dp))
        }
    }
}