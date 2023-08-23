package app.agro.samruddhi.presentation.apnabazaar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.login.ui.LoginTopBar

@Composable
fun ShopBazaar() {
    Scaffold(
        topBar = {
            LoginTopBar(
                isBackVisible = true,
                title = R.string.app_name,
                icon = R.drawable.lucide_wheat
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.onPrimary
                )
                .padding(it)
        ) {

        }
    }
}