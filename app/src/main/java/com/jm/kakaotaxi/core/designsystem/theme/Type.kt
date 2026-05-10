package com.jm.kakaotaxi.core.designsystem.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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



val localKakaoTypography = staticCompositionLocalOf { defaultKakaoTypography }


// Typography 프리뷰
@Preview(showBackground = true)
@Composable
fun TypographyPreview() {
    KakaotaxiTheme {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("TITLE", style = KakaoTheme.typography.title.kakaoEb22)
            Text("kakaoEb22", style = KakaoTheme.typography.title.kakaoEb22)
            Text("kakaoEb20", style = KakaoTheme.typography.title.kakaoEb20)
            Text("kakaoB20", style = KakaoTheme.typography.title.kakaoB20)
            Text("kakaoEb18", style = KakaoTheme.typography.title.kakaoEb18)
            Text("kakaoB18", style = KakaoTheme.typography.title.kakaoB18)

            Spacer(modifier = Modifier.height(8.dp))

            Text("BODY", style = KakaoTheme.typography.title.kakaoEb22)
            Text("kakaoEb16", style = KakaoTheme.typography.body.kakaoEb16)
            Text("kakaoB16", style = KakaoTheme.typography.body.kakaoB16)
            Text("kakaoEb14", style = KakaoTheme.typography.body.kakaoEb14)
            Text("kakaoB14", style = KakaoTheme.typography.body.kakaoB14)
            Text("kakaoR14", style = KakaoTheme.typography.body.kakaoR14)
            Text("kakaoR13", style = KakaoTheme.typography.body.kakaoR13)

            Spacer(modifier = Modifier.height(8.dp))

            Text("LABEL", style = KakaoTheme.typography.title.kakaoEb22)
            Text("kakaoEb12", style = KakaoTheme.typography.label.kakaoEb12)
            Text("kakaoB12", style = KakaoTheme.typography.label.kakaoB12)
            Text("kakaoR12", style = KakaoTheme.typography.label.kakaoR12)
            Text("kakaoR11", style = KakaoTheme.typography.label.kakaoR11)
            Text("kakaoB10", style = KakaoTheme.typography.label.kakaoB10)
            Text("kakaoR10", style = KakaoTheme.typography.label.kakaoR10)
            Text("kakaoR8", style = KakaoTheme.typography.label.kakaoR8)
        }
    }
}