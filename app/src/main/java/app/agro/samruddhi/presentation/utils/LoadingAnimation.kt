package app.agro.samruddhi.presentation.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.samruddhi.smartagro.presentation.apnabazaar.ApnaBazaarViewModel

@Composable
fun LoadingAnimation(apnaBazaarViewModel: ApnaBazaarViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AutoSlider(
            sliderList = apnaBazaarViewModel.sliderLists,
            isDotsVisible = false,
            slidingSpeed = 700
        )
    }
}