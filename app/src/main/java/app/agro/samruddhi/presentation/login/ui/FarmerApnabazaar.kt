package app.agro.samruddhi.presentation.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.R

@Composable
fun FarmerApnabazaar() {

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
                text = "Take a Picture",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Row(modifier = Modifier.padding(start = 10.dp, top = 4.dp)) {
            Text(
                text = "Fit the crop image with the frame",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        )

        {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                    .clip(RoundedCornerShape(15.dp))
            ) {

                Row() {


                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(start = 15.dp, top = 6.dp)
                            .size(23.dp)
                    )

                    Text(
                        text = "Search here...",
                        fontSize = 17.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 3.dp, top = 5.dp, bottom = 8.dp)
                    )
                }
            }
        }

       FarmerApnabazaarCard(image = R.drawable.wheat, Crop = "Wheat", QuantityNo = "20kg", PriceAmount ="1000" )
        FarmerApnabazaarCard(image = R.drawable.apple, Crop = "Apple", QuantityNo = "20kg", PriceAmount ="1000" )
        FarmerApnabazaarCard(image = R.drawable.cottonimg, Crop = "Cotton", QuantityNo = "20kg", PriceAmount ="1000" )
        FarmerApnabazaarCard(image = R.drawable.maizeimg, Crop = "Maize", QuantityNo = "20kg", PriceAmount ="1000" )
    }
}





@Composable
fun FarmerApnabazaarCard(image:Int , Crop: String, QuantityNo : String , PriceAmount :String ) {

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
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = Crop,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 3.dp, bottom = 4.dp)
                )

                Row {
                    Text(
                        text = "Quantity",
                        fontSize = 17.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 15.dp, top = 2.dp, bottom = 2.dp)
                    )
                    Text(
                        text = QuantityNo,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp, bottom = 2.dp)
                    )
                }
                Row {
                    Text(
                        text = "Price",
                        fontSize = 17.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 15.dp, top = 1.dp, bottom = 2.dp)
                    )
                    Text(
                        text = "Rs $PriceAmount" ,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 35.dp, top = 1.dp, bottom = 2.dp)
                    )

                }
            }
        }
    }
}