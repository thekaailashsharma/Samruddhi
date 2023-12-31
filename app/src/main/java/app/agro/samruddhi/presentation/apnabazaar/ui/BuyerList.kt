package app.agro.samruddhi.presentation.apnabazaar.ui

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AssignmentTurnedIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.navigation.Screens

@Composable
fun BuyerList(navController: NavController) {
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
                text = stringResource(R.string.apna_bazaar_my_crops),
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.wheat_preview),
                    contentDescription = ""
                )
            }
            Row(modifier = Modifier.padding(start = 20.dp, top = 15.dp)) {
                Text(
                    text = stringResource(R.string.interested_buyers),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        BuyerListCard(
            image = R.drawable.profile,
            priceAmount = "10/-kg",
            navController = navController
        )
        BuyerListCard(
            image = R.drawable.profile,
            priceAmount = "11/-kg",
            navController = navController
        )
        BuyerListCard(
            image = R.drawable.profile,
            priceAmount = "15/-kg",
            navController = navController
        )


    }
}


@Composable
fun BuyerListCard(image: Int, priceAmount: String, navController: NavController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                navController.navigate(Screens.ConfirmBuyer.route)
            },
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
                    .size(100.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Row {

                    LazyRow {
                        items(5) { listItem ->
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.surfaceTint,
                                modifier = Modifier
                                    .padding(start = 6.dp, top = 10.dp)
                                    .size(26.dp)
                            )
                        }
                    }
                    Icon(
                        imageVector = Icons.Outlined.AssignmentTurnedIn,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier
                            .padding(start = 25.dp, top = 5.dp, end = 1.dp)
                            .size(26.dp)
                    )
                }


                Row {
                    Text(
                        text = stringResource(R.string.bid_price),
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 2.dp)
                    )
                    Text(
                        text = "Rs $priceAmount",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 2.dp)
                    )

                }
            }
        }
    }
}
