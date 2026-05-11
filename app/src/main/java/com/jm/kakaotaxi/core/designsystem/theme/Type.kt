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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.jm.kakaotaxi.R

object KakaoSansFont {
    val extrabold = FontFamily(Font(R.font.kakaobigsans_extrabold))
    val bold = FontFamily(Font(R.font.kakaosmallsans_bold))
    val regular = FontFamily(Font(R.font.kakaosmallsans_regular))
}

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

@Immutable
data class KakaoTypography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val label: TypographyTokens.Label
)


private fun kakaoTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = 1.5.em,
    letterSpacing: TextUnit = (-0.005).em,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

val defaultKakaoTypography = KakaoTypography(

    // title 폰트
    title = TypographyTokens.Title(
        kakaoEb22 = kakaoTextStyle(
            fontFamily = KakaoSansFont.extrabold,
            fontSize = 22.sp
        ),
        kakaoEb20 = kakaoTextStyle(
            fontFamily = KakaoSansFont.extrabold,
            fontSize = 20.sp
        ),
        kakaoB20 = kakaoTextStyle(
            fontFamily = KakaoSansFont.bold,
            fontSize = 20.sp
        ),
        kakaoEb18 = kakaoTextStyle(
            fontFamily = KakaoSansFont.extrabold,
            fontSize = 18.sp
        ),
        kakaoB18 = kakaoTextStyle(
            fontFamily = KakaoSansFont.bold,
            fontSize = 18.sp
        )
    ),

    // body 폰트
    body = TypographyTokens.Body(
        kakaoEb16 = kakaoTextStyle(
            fontFamily = KakaoSansFont.extrabold,
            fontSize = 16.sp
        ),
        kakaoB16 = kakaoTextStyle(
            fontFamily = KakaoSansFont.bold,
            fontSize = 16.sp
        ),
        kakaoEb14 = kakaoTextStyle(
            fontFamily = KakaoSansFont.extrabold,
            fontSize = 14.sp
        ),
        kakaoB14 = kakaoTextStyle(
            fontFamily = KakaoSansFont.bold,
            fontSize = 14.sp
        ),
        kakaoR14 = kakaoTextStyle(
            fontFamily = KakaoSansFont.regular,
            fontSize = 14.sp
        ),
        kakaoR13 = kakaoTextStyle(
            fontFamily = KakaoSansFont.regular,
            fontSize = 13.sp
        )
    ),

    // label 폰트
    label = TypographyTokens.Label(
        kakaoEb12 = kakaoTextStyle(
            fontFamily = KakaoSansFont.extrabold,
            fontSize = 12.sp
        ),
        kakaoB12 = kakaoTextStyle(
            fontFamily = KakaoSansFont.bold,
            fontSize = 12.sp
        ),
        kakaoR12 = kakaoTextStyle(
            fontFamily = KakaoSansFont.regular,
            fontSize = 12.sp
        ),
        kakaoR11 = kakaoTextStyle(
            fontFamily = KakaoSansFont.regular,
            fontSize = 11.sp
        ),
        kakaoB10 = kakaoTextStyle(
            fontFamily = KakaoSansFont.bold,
            fontSize = 10.sp
        ),
        kakaoR10 = kakaoTextStyle(
            fontFamily = KakaoSansFont.regular,
            fontSize = 10.sp
        ),
        kakaoR8 = kakaoTextStyle(
            fontFamily = KakaoSansFont.regular,
            fontSize = 8.sp
        )
    )
)



val LocalKakaoTypography = staticCompositionLocalOf { defaultKakaoTypography }


// Typography 프리뷰
@Preview(showBackground = true)
@Composable
fun TypographyPreview() {
    KakaotaxiTheme {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("TITLE", style = KakaotaxiTheme.typography.title.kakaoEb22)
            Text("kakaoEb22", style = KakaotaxiTheme.typography.title.kakaoEb22)
            Text("kakaoEb20", style = KakaotaxiTheme.typography.title.kakaoEb20)
            Text("kakaoB20", style = KakaotaxiTheme.typography.title.kakaoB20)
            Text("kakaoEb18", style = KakaotaxiTheme.typography.title.kakaoEb18)
            Text("kakaoB18", style = KakaotaxiTheme.typography.title.kakaoB18)

            Spacer(modifier = Modifier.height(8.dp))

            Text("BODY", style = KakaotaxiTheme.typography.title.kakaoEb22)
            Text("kakaoEb16", style = KakaotaxiTheme.typography.body.kakaoEb16)
            Text("kakaoB16", style = KakaotaxiTheme.typography.body.kakaoB16)
            Text("kakaoEb14", style = KakaotaxiTheme.typography.body.kakaoEb14)
            Text("kakaoB14", style = KakaotaxiTheme.typography.body.kakaoB14)
            Text("kakaoR14", style = KakaotaxiTheme.typography.body.kakaoR14)
            Text("kakaoR13", style = KakaotaxiTheme.typography.body.kakaoR13)

            Spacer(modifier = Modifier.height(8.dp))

            Text("LABEL", style = KakaotaxiTheme.typography.title.kakaoEb22)
            Text("kakaoEb12", style = KakaotaxiTheme.typography.label.kakaoEb12)
            Text("kakaoB12", style = KakaotaxiTheme.typography.label.kakaoB12)
            Text("kakaoR12", style = KakaotaxiTheme.typography.label.kakaoR12)
            Text("kakaoR11", style = KakaotaxiTheme.typography.label.kakaoR11)
            Text("kakaoB10", style = KakaotaxiTheme.typography.label.kakaoB10)
            Text("kakaoR10", style = KakaotaxiTheme.typography.label.kakaoR10)
            Text("kakaoR8", style = KakaotaxiTheme.typography.label.kakaoR8)
        }
    }
}