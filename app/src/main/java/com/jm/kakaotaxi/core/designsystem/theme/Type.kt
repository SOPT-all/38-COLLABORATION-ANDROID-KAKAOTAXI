package com.jm.kakaotaxi.core.designsystem.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.jm.kakaotaxi.R

private val KakaoSansFontFamily = FontFamily(
    Font(R.font.kakaobigsans_bold, weight = FontWeight.Bold),
    Font(R.font.kakaobigsans_extrabold, weight = FontWeight.ExtraBold)
)

data class KakaoTypography(
    val title: TitleTypography,
    val body: BodyTypography,
    val label: LabelTypography
)

// Title
data class TitleTypography(
    val Kakao_eb_22: TextStyle,
    val Kakao_eb_20: TextStyle,
    val Kakao_b_20: TextStyle,
    val Kakao_eb_18: TextStyle,
    val Kakao_b_18: TextStyle
)

private val Kakao_eb_22 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 22.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_eb_20 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 20.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_b_20 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_eb_18 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 18.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_b_18 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

// Body
data class BodyTypography(
    val Kakao_eb_16: TextStyle,
    val Kakao_b_16: TextStyle,
    val Kakao_eb_14: TextStyle,
    val Kakao_b_14: TextStyle
)

private val Kakao_eb_16 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 16.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_b_16 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_eb_14 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 14.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_b_14 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

// Label
data class LabelTypography(
    val Kakao_eb_12: TextStyle,
    val Kakao_b_12: TextStyle
)

private val Kakao_eb_12 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 12.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

private val Kakao_b_12 = TextStyle(
    fontFamily = KakaoSansFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 1.5.em,
    letterSpacing = (-0.005).em
)

val Typography = KakaoTypography(
    title = TitleTypography(
        Kakao_eb_22 = Kakao_eb_22,
        Kakao_eb_20 = Kakao_eb_20,
        Kakao_b_20 = Kakao_b_20,
        Kakao_eb_18 = Kakao_eb_18,
        Kakao_b_18 = Kakao_b_18
    ),
    body = BodyTypography(
        Kakao_eb_16 = Kakao_eb_16,
        Kakao_b_16 = Kakao_b_16,
        Kakao_eb_14 = Kakao_eb_14,
        Kakao_b_14 = Kakao_b_14
    ),
    label = LabelTypography(
        Kakao_eb_12 = Kakao_eb_12,
        Kakao_b_12 = Kakao_b_12
    )
)

val LocalKaKaoTypography = staticCompositionLocalOf {
    Typography
}


@Preview(showBackground = true)
@Composable
fun KakaoTypographyPreview() {
    KakaotaxiTheme {
        Column {
            Text("TITLE")
            Text("Kakao_eb_22", style = Typography.title.Kakao_eb_22)
            Text("Kakao_eb_20", style = Typography.title.Kakao_eb_20)
            Text("Kakao_b_20", style = Typography.title.Kakao_b_20)
            Text("Kakao_eb_18", style = Typography.title.Kakao_eb_18)
            Text("Kakao_b_18", style = Typography.title.Kakao_b_18)

            Spacer(modifier = Modifier.height(10.dp))

            Text("BODY")
            Text("Kakao_eb_16", style = Typography.body.Kakao_eb_16)
            Text("Kakao_b_16", style = Typography.body.Kakao_b_16)
            Text("Kakao_eb_14", style = Typography.body.Kakao_eb_14)
            Text("Kakao_b_14", style = Typography.body.Kakao_b_14)

            Spacer(modifier = Modifier.height(10.dp))

            Text("LABEL")
            Text("kakao_eb_12", style = Typography.label.Kakao_eb_12)
            Text("kakao_b_12", style = Typography.label.Kakao_b_12)
        }
    }
}