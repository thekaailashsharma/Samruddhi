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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.material.icons.outlined.AssignmentTurnedIn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
fun BuyerList() {
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

        Spacer(modifier = Modifier.height(10.dp))
        Column() {
            Row {
                Image(painter = painterResource(id = R.drawable.wheat), contentDescription = "")
            }
            Row(modifier = Modifier.padding(start = 20.dp, top = 15.dp)) {
                Text(
                    text = "Interested Buyers",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        BuyerListCard(image = R.drawable.profile, PriceAmount ="11" )
        BuyerListCard(image = R.drawable.profile, PriceAmount ="11" )
        BuyerListCard(image = R.drawable.profile, PriceAmount ="11" )



    }
}



@Composable
fun BuyerListCard(image:Int ,PriceAmount :String ) {

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
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 6.dp, top = 10.dp,)
                    .size(26.dp)
            )
        }
    }
    Icon(
        imageVector = Icons.Outlined.AssignmentTurnedIn,
//        imageVector = Icons.Filled.AssignmentTurnedIn,
        contentDescription = "",
        tint = Color.White,
        modifier = Modifier
            .padding(start = 25.dp, top = 5.dp, end = 1.dp)
            .size(26.dp)
    )
}


                Row {
                    Text(
                        text = " Bid Price",
                        fontSize = 17.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 2.dp)
                    )
                    Text(
                        text = "Rs $PriceAmount" ,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 2.dp)
                    )

                }
            }
        }
    }
}
