package app.agro.samruddhi.presentation.apnabazaar.ui

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.utils.BookedAnimation

@Composable
fun BuyerAccRej(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        var isDealAccepted by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(
                    MaterialTheme.colorScheme.onPrimary
                )
                .then(
                    if (isDealAccepted) Modifier.blur(5.dp) else Modifier
                )
        ) {
            Row(modifier = Modifier.padding(start = 20.dp, top = 30.dp)) {
                Text(
                    text = stringResource(id = R.string.apna_bazaar_my_crops),
                    fontSize = 25.sp,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
            Row(modifier = Modifier.padding(start = 20.dp, top = 15.dp)) {
                Text(
                    text = stringResource(id = R.string.interested_buyers),
                    fontSize = 23.sp,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            BuyerAccDecCard(image = R.drawable.group, Price = "1000")
            Text(
                text = stringResource(R.string.requirements),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.surfaceTint,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 15.dp, top = 23.dp, bottom = 2.dp)
            )
            Text(
                text = stringResource(R.string.quantity_120_kg_month),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 2.dp)
            )
            Text(
                text = stringResource(R.string.duration_6_month),
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

                Card(
                    modifier = Modifier,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    ),
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Text(
                        text = stringResource(R.string.decline),
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
                Card(
                    modifier = Modifier.clickable {
                        isDealAccepted = true
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    ),
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Text(
                        text = stringResource(R.string.accept),
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
        if (isDealAccepted) {
            BookedAnimation(navController = navController)
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
                        text = stringResource(id = R.string.bid_price),
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