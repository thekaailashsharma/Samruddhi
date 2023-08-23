package app.agro.samruddhi.presentation.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun Weather() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.onPrimary
            )
    ) {
        Row(modifier = Modifier.padding(start = 30.dp, top = 30.dp)) {
            Text(
                text = stringResource(R.string.mausam_charcha),
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 20.dp, end = 30.dp, bottom = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, top = 15.dp)
                ) {
                    Text(
                        text = stringResource(R.string.navi_mumbai),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.surfaceTint
                    )
                    Text(
                        text = stringResource(R.string.tue_jun_30),
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.surfaceTint
                    )
                    Text(fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp),
                        text = buildAnnotatedString {
                            append(stringResource(R.string._19))
                            withStyle(
                                SpanStyle(
                                    baselineShift = BaselineShift.Superscript, fontSize = 20.sp
                                )
                            ) {
                                append(stringResource(R.string.o))
                            }
                        })
                    Text(
                        text = stringResource(R.string.rainy),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 10.dp),
                        color = MaterialTheme.colorScheme.surfaceTint
                    )
                }
                val compnotify by rememberLottieComposition(
                    spec = LottieCompositionSpec.Asset("cloud.json")
                )
                val progress by animateLottieCompositionAsState(compnotify)
                LottieAnimation(
                    composition = compnotify,
                    iterations = Int.MAX_VALUE,
                    isPlaying = true,
                    contentScale = ContentScale.Crop,
                    speed = 1.45f,
                    modifier = Modifier
                        .size(100.dp)

                )

            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 20.dp, end = 30.dp, bottom = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "It is a Rainy day Today",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    color = MaterialTheme.colorScheme.surfaceTint
                )
                Text(
                    text = "Today would be a bad day for applying pesticides",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    color = MaterialTheme.colorScheme.surfaceTint,
                    softWrap = true
                )

            }
        }
        ReusableWeatherCard(
            image = R.drawable.umbrella,
            middleText = R.string.It_is_a_Rainy_day_Today,
            endText = R.string.humidity_value
        )
        ReusableWeatherCard(
            image = R.drawable.wind,
            middleText = R.string.It_is_a_Rainy_day_Today,
            endText = R.string.humidity_value
        )
        ReusableWeatherCard(
            image = R.drawable.humidity,
            middleText = R.string.It_is_a_Rainy_day_Today,
            endText = R.string.humidity_value
        )
    }
}

@Composable
fun ReusableWeatherCard(image: Int, middleText: Int, endText: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 20.dp, end = 30.dp, bottom = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = middleText),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                softWrap = true

            )
            Text(
                text = stringResource(id = endText),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = 7.dp),
                color = MaterialTheme.colorScheme.surfaceTint,
                softWrap = true
            )
        }
    }
}