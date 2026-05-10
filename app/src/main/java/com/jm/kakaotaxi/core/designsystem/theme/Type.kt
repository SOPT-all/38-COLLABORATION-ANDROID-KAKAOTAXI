package com.jm.kakaotaxi.core.designsystem.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.jm.kakaotaxi.R

private val kakaoSansFontFamily = FontFamily(
    Font(R.font.kakaobigsans_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.kakaobigsans_bold, weight = FontWeight.Bold),
    Font(R.font.kakaobigsans_regular, weight = FontWeight.Normal)
)

sealed interface TypographyTokens {
    @Immutable
    data class Title(
        val kakaoEb22: TextStyle,
        val kakaoEb20: TextStyle,
        val kakaoB20: TextStyle,
        val kakaoEb18: TextStyle,
        val kakaoB18: TextStyle
    ) : TypographyTokens

    @Immutable
    data class Body(
        val kakaoEb16: TextStyle,
        val kakaoB16: TextStyle,
        val kakaoEb14: TextStyle,
        val kakaoB14: TextStyle,
        val kakaoR14 : TextStyle,
        val kakaoR13 : TextStyle
    ) : TypographyTokens

    @Immutable
    data class Label(
        val kakaoEb12: TextStyle,
        val kakaoB12: TextStyle,
        val kakaoR12: TextStyle,
        val kakaoR11: TextStyle,
        val kakaoB10: TextStyle,
        val kakaoR10: TextStyle,
        val kakaoR8: TextStyle
    ) : TypographyTokens
}

data class KakaoTypography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val label: TypographyTokens.Label
)


private fun KakaoTextStyle(
    fontFamily: FontFamily = kakaoSansFontFamily,
    fontWeight : FontWeight,
    fontSize: TextUnit,
    lineHeight: TextUnit = 1.5.em,
    letterSpacing: TextUnit = (-0.005).em,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontWeight = fontWeight,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

val defaultKakaoTypography = KakaoTypography(

    // title 폰트
    title = TypographyTokens.Title(
        kakaoEb22 = KakaoTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp
        ),
        kakaoEb20 = KakaoTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        ),
        kakaoB20 = KakaoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        ),
        kakaoEb18 = KakaoTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp
        ),
        kakaoB18 = KakaoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    ),

    // body 폰트
    body = TypographyTokens.Body(
        kakaoEb16 = KakaoTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp
        ),
        kakaoB16 = KakaoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        kakaoEb14 = KakaoTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp
        ),
        kakaoB14 = KakaoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        ),
        kakaoR14 = KakaoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        kakaoR13 = KakaoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )
    ),

    // label 폰트
    label = TypographyTokens.Label(
        kakaoEb12 = KakaoTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 12.sp
        ),
        kakaoB12 = KakaoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        ),
        kakaoR12 = KakaoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        kakaoR11 = KakaoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp
        ),
        kakaoB10 = KakaoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp
        ),
        kakaoR10 = KakaoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        ),
        kakaoR8 = KakaoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 8.sp
        )
    )
)



val LocalKaKaoTypography = staticCompositionLocalOf { defaultKakaoTypography }


//@Preview(showBackground = true)
//@Composable
//fun KakaoTypographyPreview() {
//    KakaotaxiTheme {
//        Column {
//            Text("TITLE")
//            Text("Kakao_eb_22", style = typography.Title.Kakao_eb_22)
//            Text("Kakao_eb_20", style = Typography.title.Kakao_eb_20)
//            Text("Kakao_b_20", style = Typography.title.Kakao_b_20)
//            Text("Kakao_eb_18", style = Typography.title.Kakao_eb_18)
//            Text("Kakao_b_18", style = Typography.title.Kakao_b_18)
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Text("BODY")
//            Text("Kakao_eb_16", style = Typography.body.kakao_eb_16)
//            Text("Kakao_b_16", style = Typography.body.kakao_b_16)
//            Text("Kakao_eb_14", style = Typography.body.kakao_eb_14)
//            Text("Kakao_b_14", style = Typography.body.kakao_b_14)
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Text("LABEL")
//            Text("kakao_eb_12", style = Typography.label.Kakao_eb_12)
//            Text("kakao_b_12", style = Typography.label.Kakao_b_12)
//        }
//    }
//}