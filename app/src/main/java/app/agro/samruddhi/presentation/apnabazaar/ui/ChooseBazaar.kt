package app.agro.samruddhi.presentation.apnabazaar.ui

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ChooseBazaar(
    val image: Int,
    val title: Int,
    val onClick: () -> Unit = {},
    val iconSize: Dp = 80.dp
)