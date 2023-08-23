package app.agro.samruddhi.presentation.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material.icons.outlined.AssignmentTurnedIn
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Whatsapp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.R
import app.agro.samruddhi.ui.theme.Select

@Composable
fun FarmerList() {

    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Wheat",
                fontSize = 25.sp,
                modifier = Modifier.padding(start = 140.dp, top = 30.dp),
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.wheat),
                contentDescription = "",
                modifier = Modifier.padding(top = 20.dp, start = 35.dp, end = 35.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Quantity",
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 40.dp, top = 20.dp),
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Text(
                text = "25 kg",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 100.dp, top = 20.dp),
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 40.dp, top = 15.dp)
                    .size(30.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 35.dp, end = 35.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "",
                modifier = Modifier.size(50.dp)

            )
            Text(
                text = "Rs 1000",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(start = 60.dp, top = 10.dp, bottom = 2.dp, end = 60.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.minus),
                contentDescription = "",
                modifier = Modifier.size(50.dp)

            )
        }


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 25.dp, end = 25.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.group),
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row {

                        Text(
                            text = "ABC",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 2.dp)
                        )

                    }
                    Row {

                        LazyRow {
                            items(5) { listItem ->
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .padding(start = 6.dp, top = 10.dp)
                                        .size(26.dp)
                                )
                            }
                        }

                    }


                }
            }
        }
        Contact(Icon = Icons.Outlined.Phone, text ="Contact Farmer" )
        Contact(Icon = Icons.Outlined.Whatsapp, text = "Chat on Whatsapp")
        Select(text = "Make a deal")

    }
}


@Composable
fun Contact(Icon: ImageVector, text: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp)) {
        Icon(
            imageVector = Icon,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .padding(start = 6.dp, top = 10.dp)
                .size(26.dp)
        )
        Text(
            text = text,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 2.dp)
        )

    }
}