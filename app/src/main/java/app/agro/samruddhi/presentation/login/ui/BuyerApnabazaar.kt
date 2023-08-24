package app.agro.samruddhi.presentation.login.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.R

@Composable
fun BuyerApnabazaar() {
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
            image = R.drawable.wheat,
            Crop = "Wheat"
        )
        BuyerApnabazaarCard(
            image = R.drawable.apple,
            Crop = "Apple"
        )
        BuyerApnabazaarCard(
            image = R.drawable.maizeimg,
            Crop = "Maize"
        )
        BuyerApnabazaarCard(
            image = R.drawable.cottonimg,
            Crop = "Cotton"
        )
    }
}


@Composable
fun BuyerApnabazaarCard(image: Int, Crop: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(15.dp))
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
                    text = Crop,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 30.dp, top = 40.dp, bottom = 4.dp)
                )


            }
        }
    }
}