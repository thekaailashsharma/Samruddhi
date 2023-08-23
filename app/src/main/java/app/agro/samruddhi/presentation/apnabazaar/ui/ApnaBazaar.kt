package app.agro.samruddhi.presentation.apnabazaar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.login.ui.LoginTopBar
import app.agro.samruddhi.presentation.utils.BottomBar
import app.agro.samruddhi.presentation.utils.LoadingAnimation
import app.samruddhi.smartagro.presentation.apnabazaar.ApnaBazaarViewModel
import kotlinx.coroutines.delay

@Composable
fun ApnaBazaar(
    navController: NavController,
    apnaBazaarViewModel: ApnaBazaarViewModel = hiltViewModel()
) {
    val isAnimationPlaying by rememberUpdatedState(newValue = apnaBazaarViewModel.isAnimationPlaying.value)
    Scaffold(
        topBar = {
            LoginTopBar(
                isBackVisible = true,
                title = R.string.app_name,
                icon = R.drawable.lucide_wheat
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        LaunchedEffect(key1 = apnaBazaarViewModel.isAnimationPlaying) {
            apnaBazaarViewModel.isAnimationPlaying.value = true
            delay(7000)
            if (apnaBazaarViewModel.isAnimationPlaying.value)
                apnaBazaarViewModel.isAnimationPlaying.value = false
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .then(
                        if (isAnimationPlaying)
                            Modifier.blur(10.dp)
                        else Modifier
                    )
                    .fillMaxSize()
                    .background(
                        MaterialTheme.colorScheme.onPrimary
                    )
                    .padding(it)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.apnaBazar),
                        modifier = Modifier,
                        color = MaterialTheme.colorScheme.surfaceTint,
                        fontSize = 30.sp
                    )
                    Text(
                        text = stringResource(id = R.string.find_best_products_from_nearby_store),
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 10.dp),
                        color = MaterialTheme.colorScheme.surfaceTint,
                        fontSize = 15.sp,
                        softWrap = true
                    )
                }
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .wrapContentHeight(),
                    contentPadding = PaddingValues(
                        top = 20.dp,
                        bottom = 60.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
                ) {
                    items(apnaBazaarViewModel.chooseBazaarList) { bazaar ->
                        ChooseBazaarCard(
                            icon = bazaar.image,
                            title = bazaar.title,
                            iconSize = bazaar.iconSize
                        ) {

                        }

                    }
                }
            }
            if (isAnimationPlaying) {
                LoadingAnimation(apnaBazaarViewModel = apnaBazaarViewModel)
            }
        }
    }
}

@Composable
fun ChooseBazaarCard(
    icon: Int,
    title: Int,
    iconSize: Dp = 80.dp,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 10.dp)
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = stringResource(id = title),
                tint = Color.Unspecified,
                modifier = Modifier.size(iconSize)
            )
            Text(
                text = stringResource(id = title),
                modifier = Modifier.padding(10.dp),
                color = MaterialTheme.colorScheme.surfaceTint,
                fontSize = 26.sp
            )

        }
    }
}


@Preview
@Composable
fun ChooseBazaarCardPreview() {
    ChooseBazaarCard(
        icon = R.drawable.eqipments,
        title = R.string.equipments
    ) {

    }
}