package com.jm.kakaotaxi.presentation.arrival

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.ButtonItem
import com.jm.kakaotaxi.core.designsystem.component.ButtonStyle
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiBottomSheet
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.arrival.component.ArriveItem

@Composable
fun ArrivalRoute(
    modifier: Modifier = Modifier,
    viewModel: ArrivalViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ArrivalScreen(
        taxiType = uiState.taxiType,
        carNumber = uiState.carNumber,
        carType = uiState.carType,
        carColor = uiState.carColor,
        driverName = uiState.driverName,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ArrivalScreen(
    taxiType: String,
    carNumber: String,
    carType: String,
    carColor: String,
    driverName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_arrival_map),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrivescreen_gps),
            contentDescription = null,
            modifier = Modifier.padding(top = 191.dp),
            tint = Color.Unspecified
        )

        KakaoTaxiBottomSheet(
            showScrim = false
        ) {
            Column(modifier = Modifier.padding(horizontal = 21.dp))
            {
                Spacer(modifier = Modifier.height(16.dp))

                Box {
                    Image(
                        painter = painterResource(R.drawable.img_arrival_taxi),
                        contentDescription = null
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrivescreen_arrowsout),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 15.dp, bottom = 13.dp)
                    )
                }

                Spacer(modifier = Modifier.height(31.dp))

                Row {
                    Text(
                        text = taxiType,
                        style = KakaotaxiTheme.typography.body.kakaoB16,
                        color = KakaotaxiTheme.colors.primaryBlue
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "지금 탑승 위치로 출발",
                        style = KakaotaxiTheme.typography.body.kakaoB16,
                        color = KakaotaxiTheme.colors.textPrimary
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "피크요금 1.2배 적용",
                    style = KakaotaxiTheme.typography.label.kakaoR12,
                    color = KakaotaxiTheme.colors.textSecondary
                )

                Spacer(modifier = Modifier.height(15.dp))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = KakaotaxiTheme.colors.backgroundGray
                )

                Row {
                    Image(
                        painter = painterResource(R.drawable.img_arrival_driverprofile),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 21.dp)
                            .size(size = 55.dp)
                    )

                    Spacer(modifier = Modifier.width(7.dp))

                    Column(modifier = Modifier.padding(vertical = 20.dp))
                    {
                        Row {
                            Text(
                                text = carNumber,
                                style = KakaotaxiTheme.typography.body.kakaoB16,
                                color = KakaotaxiTheme.colors.textPrimary
                            )

                            Spacer(modifier = Modifier.width(7.dp))

                            VerticalDivider(
                                modifier = Modifier
                                    .height(13.dp),
                                thickness = 1.dp,
                                color = KakaotaxiTheme.colors.backgroundGray
                            )

                            Spacer(modifier = Modifier.width(7.dp))

                            Text(
                                text = "$carType $carColor",
                                style = KakaotaxiTheme.typography.body.kakaoR14,
                                color = KakaotaxiTheme.colors.textSecondary
                            )
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "${driverName} 기사님",
                            style = KakaotaxiTheme.typography.body.kakaoR14,
                            color = KakaotaxiTheme.colors.textSecondary
                        )
                    }
                }

                ArriveItem()

                Spacer(modifier = Modifier.height(20.dp))
                //공유 버튼
                ButtonItem(
                    text = "보호자에게 공유",
                    style = ButtonStyle.SHARE,
                    onClick = {},
                    modifier = modifier.fillMaxWidth()
                )

                Spacer(modifier = modifier.height(23.dp))
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ArrivalScreenPreview() {
    KakaotaxiTheme {
        ArrivalScreen(
            taxiType = "안심택시",
            carNumber = "서울 38 아 2864",
            carType = "현대 쏘나타",
            carColor = "화이트",
            driverName = "김민수"
        )
    }
}
