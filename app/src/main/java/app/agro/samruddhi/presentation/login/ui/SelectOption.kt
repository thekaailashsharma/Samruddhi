package app.agro.samruddhi.presentation.login.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.navigation.Screens

@Composable
fun SelectOption(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.onPrimary
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.select),
                contentDescription = "", alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(235.dp)
            )
        }
        Row(modifier = Modifier.padding(start = 10.dp, top = 40.dp)) {
            Text(
                text = "Are you a Farmer or a Buyer?",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Select(text = "Farmers") {
            navController.navigate(Screens.Login.route)
        }
        Select(text = "Buyer") {
            navController.navigate(Screens.BuyerApnaBazaar.route)
        }


    }
}

@Composable
fun Select(
    text: String,
    onClick: () -> Unit = {}
) {
    Row(modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 20.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
            border = BorderStroke(1.dp, Color.Green)
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 130.dp, top = 12.dp, bottom = 12.dp),
                color = MaterialTheme.colorScheme.surfaceTint,
                softWrap = true
            )
        }
    }
}