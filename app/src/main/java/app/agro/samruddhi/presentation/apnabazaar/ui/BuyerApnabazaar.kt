package app.agro.samruddhi.presentation.apnabazaar.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.navigation.Screens
import app.agro.samruddhi.presentation.utils.LoadingAnimation
import app.samruddhi.smartagro.presentation.apnabazaar.ApnaBazaarViewModel
import kotlinx.coroutines.delay

@Composable
fun BuyerApnabazaar(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                MaterialTheme.colorScheme.onPrimary
            )
    ) {
        Row(modifier = Modifier.padding(start = 10.dp, top = 30.dp)) {
            Text(
                text = "Apna Bazaar - My Crops",
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        BuyerApnabazaarCard(
            image = R.drawable.wheat_preview,
            crop = "Wheat",
            navController = navController
        )
        BuyerApnabazaarCard(
            image = R.drawable.apple,
            crop = "Apple",
            navController = navController
        )
        BuyerApnabazaarCard(
            image = R.drawable.maizeimg,
            crop = "Maize",
            navController = navController
        )
        BuyerApnabazaarCard(
            image = R.drawable.cottonimg,
            crop = "Cotton",
            navController = navController
        )
    }
}


@Composable
fun BuyerApnabazaarCard(
    image: Int,
    crop: String,
    navController: NavController,
    apnaBazaarViewModel: ApnaBazaarViewModel = hiltViewModel()
) {
    val isAnimationPlaying by rememberUpdatedState(newValue = apnaBazaarViewModel.isAnimationPlaying.value)
    LaunchedEffect(key1 = apnaBazaarViewModel.isAnimationPlaying) {
        apnaBazaarViewModel.isAnimationPlaying.value = true
        delay(7000)
        if (apnaBazaarViewModel.isAnimationPlaying.value)
            apnaBazaarViewModel.isAnimationPlaying.value = false
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(15.dp))
                .clickable {
                    navController.navigate(Screens.FarmerList.route)
                }
                .then(
                    if (isAnimationPlaying)
                        Modifier.blur(10.dp)
                    else Modifier
                ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(10.dp),
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(image),
                    contentDescription = "",
                    modifier = Modifier
                        .height(120.dp)
                        .width(160.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = crop,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier
                            .padding(start = 30.dp, top = 40.dp, bottom = 4.dp)
                    )


                }
            }
        }
        if (isAnimationPlaying) {
            LoadingAnimation(apnaBazaarViewModel = apnaBazaarViewModel)
        }
    }
}