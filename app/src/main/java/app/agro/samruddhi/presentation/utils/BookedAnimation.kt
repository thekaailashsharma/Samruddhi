package app.agro.samruddhi.presentation.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.agro.samruddhi.presentation.navigation.Screens
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun BookedAnimation(navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navController.navigate(Screens.Home.route)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val compnotify by rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("deal.json")
        )
        LottieAnimation(
            composition = compnotify,
            iterations = Int.MAX_VALUE,
            isPlaying = true,
            contentScale = ContentScale.Crop,
            speed = 1.45f,
            modifier = Modifier
                .size(500.dp)
                .padding(2.dp)

        )

    }
}