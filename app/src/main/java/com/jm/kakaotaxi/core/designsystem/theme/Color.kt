package com.jm.kakaotaxi.core.designsystem.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Immutable
object PrimaryColor {
    val blue_600 = Color(0xFF096AE8)
}

@Immutable
object GreyColor {
    val grey_900 = Color(0xFF282C37)
    val grey_800 = Color(0xFF414747)
    val grey_700 = Color(0xFF626871)
    val grey_600 = Color(0xFF777777)
    val grey_500 = Color(0xFF9D9D9D)
    val grey_400 = Color(0xFF93969D)
    val grey_300 = Color(0xFFD9D9D9)
    val grey_200 = Color(0xFFDCDDDF)
    val grey_150 = Color(0xFFE6E7E9)
    val grey_100 = Color(0xFFF1F1F1)
    val grey_50 = Color(0xFFF8F8F8)
}

@Immutable
object SubColor {
    val sub_red_500 = Color(0xFFD02020)
    val sub_red_700 = Color(0xFF90292C)

    val sub_yellow_500 = Color(0xFFFFE826)
    val sub_yellow_700 = Color(0xFFEDBC00)
}

@Immutable
object StaticColor {
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
}

@Preview(showBackground = true)
@Composable
fun ColorPreview() {
    val greyColors = listOf(
        "grey_900" to GreyColor.grey_900,
        "grey_800" to GreyColor.grey_800,
        "grey_700" to GreyColor.grey_700,
        "grey_600" to GreyColor.grey_600,
        "grey_500" to GreyColor.grey_500,
        "grey_400" to GreyColor.grey_400,
        "grey_300" to GreyColor.grey_300,
        "grey_200" to GreyColor.grey_200,
        "grey_150" to GreyColor.grey_150,
        "grey_100" to GreyColor.grey_100,
        "grey_50" to GreyColor.grey_50
    )

    val subColors = listOf(
        "sub_red_500" to SubColor.sub_red_500,
        "sub_red_700" to SubColor.sub_red_700,
        "sub_yellow_500" to SubColor.sub_yellow_500,
        "sub_yellow_700" to SubColor.sub_yellow_700
    )

    val staticColors = listOf(
        "White" to StaticColor.White,
        "Black" to StaticColor.Black
    )

    Row {
        Column {
            Text(text = "GreyColor", fontSize = 10.sp)
            greyColors.forEach { (name, color) ->
                Box(
                    modifier = Modifier
                        .height(15.dp)
                        .width(60.dp)
                        .background(color)
                ) {
                    Text(text = name, fontSize = 7.sp)
                }
            }
        }

        Column {
            Text(text = "PrimaryColor", fontSize = 10.sp)
            Box(
                modifier = Modifier
                    .height(15.dp)
                    .width(60.dp)
                    .background(PrimaryColor.blue_600)
            ) {
                Text(text = "blue_600", fontSize = 7.sp)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "SubColor", fontSize = 10.sp)
            subColors.forEach { (name, color) ->
                Box(
                    modifier = Modifier
                        .height(15.dp)
                        .width(60.dp)
                        .background(color)
                ) {
                    Text(text = name, fontSize = 7.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "StaticColor", fontSize = 10.sp)
            staticColors.forEach { (name, color) ->
                Box(
                    modifier = Modifier
                        .height(15.dp)
                        .width(60.dp)
                        .background(color)
                ) {
                    Text(text = name, fontSize = 7.sp, color = GreyColor.grey_400)
                }
            }

        }
    }

}
