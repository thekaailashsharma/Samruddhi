package app.agro.samruddhi.presentation.apnabazaar.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.agro.samruddhi.R

@Composable
fun BazaarCard(
    quantity: Int,
    price: String,
    itemName: Int,
    icon1: ImageVector?,
    icon2: ImageVector?
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Image(
                painter = painterResource(id = R.drawable.transport),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(100.dp)
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemRow(
                    text = itemName,
                    icon1 = icon1,
                    icon2 = icon2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.quantity),
                        color = MaterialTheme.colorScheme.surfaceTint,
                        fontSize = 14.sp
                    )
                    Text(
                        text = stringResource(id = R.string.price),
                        color = MaterialTheme.colorScheme.surfaceTint,
                        fontSize = 14.sp
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = quantity.toString(),
                        color = MaterialTheme.colorScheme.surfaceTint,
                        fontSize = 18.sp
                    )
                    Text(
                        text = price,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        fontSize = 18.sp
                    )

                }
            }
        }
    }
}

@Composable
fun ItemRow(text: Int, icon1: ImageVector?, icon2: ImageVector?) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = text),
            color = MaterialTheme.colorScheme.surfaceTint,
            fontSize = 22.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            icon1?.let { icon ->
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.surfaceTint,
                )
            }
            Spacer(modifier = Modifier.width(7.dp))
            icon2?.let { icon ->
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.surfaceTint,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewBazaarCard() {
    BazaarCard(
        quantity = R.string.quantity,
        price = "₹ 1000",
        itemName = R.string.sonic,
        icon1 = Icons.Filled.Call,
        icon2 = Icons.Filled.Whatsapp
    )
}

data class BazaarCardItem(
    val quantity: Int,
    val price: String,
    val itemName: Int,
    val icon1: ImageVector?,
    val icon2: ImageVector?
)