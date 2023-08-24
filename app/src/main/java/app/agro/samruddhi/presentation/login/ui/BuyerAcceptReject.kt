package app.agro.samruddhi.presentation.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.R

@Composable
fun BuyerAccRej() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                MaterialTheme.colorScheme.onPrimary
            )
    ) {
        Row(modifier = Modifier.padding(start = 20.dp, top = 30.dp)) {
            Text(
                text = "Apna Bazaar - My Crops",
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Row(modifier = Modifier.padding(start = 20.dp, top = 15.dp)) {
            Text(
                text = "Interested Buyers",
                fontSize = 23.sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        BuyerAccDecCard(image = R.drawable.group, Price = "1000")
        Text(
            text = " Requirements:",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.surfaceTint,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 15.dp, top = 23.dp, bottom = 2.dp)
        )
        Text(
            text = " Quantity : 120 kg/month",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.surfaceTint,
            modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 2.dp)
        )
        Text(
            text = " Duration : 6 month",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.surfaceTint,
            modifier = Modifier.padding(start = 15.dp, top = 2.dp, bottom = 2.dp)
        )
        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
        ) {

            Card(modifier = Modifier) {
                Text(
                    text = "Decline",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.surfaceTint,
                    modifier = Modifier.padding(
                        start = 13.dp,
                        top = 4.dp,
                        bottom = 4.dp,
                        end = 13.dp
                    )
                )
            }
            Spacer(modifier = Modifier.padding(start = 50.dp))
            Card(modifier = Modifier) {
                Text(
                    text = "Accept",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.surfaceTint,
                    modifier = Modifier.padding(
                        start = 13.dp,
                        top = 4.dp,
                        bottom = 4.dp,
                        end = 13.dp
                    )
                )
            }
        }


    }

}


@Composable
fun BuyerAccDecCard(image: Int, Price: String) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
                    .padding(5.dp),
                tint = MaterialTheme.colorScheme.surfaceTint
            )
            Column(modifier = Modifier.fillMaxWidth()) {


                Row() {
                    Text(
                        text = " Bid Price",
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 15.dp, top = 23.dp, bottom = 2.dp)
                    )
                    Text(
                        text = "Rs $Price",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 25.dp, top = 23.dp, bottom = 2.dp)
                    )

                }
            }
        }
    }
}