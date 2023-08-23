package app.agro.samruddhi.presentation.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.login.LoginViewModel
import app.agro.samruddhi.presentation.login.ui.LoginTopBar
import app.agro.samruddhi.presentation.utils.BottomBar
import app.agro.samruddhi.ui.theme.homeCardGradient
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            LoginTopBar(
                isBackVisible = true, title = R.string.app_name,
                icon = R.drawable.lucide_wheat
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(
                    MaterialTheme.colorScheme.onPrimary
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.65f)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Card(
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 50.dp,
                                topEnd = 50.dp
                            )
                        )
                        .background(homeCardGradient)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Text(text = "", color = MaterialTheme.colorScheme.onError)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        items(viewModel.homeCardList.size) { crop ->
                            HomeScreenCard(
                                image = viewModel.homeCardList[crop].image,
                                title = viewModel.homeCardList[crop].title,
                                shape = RoundedCornerShape(
                                    topStart = viewModel.homeCardList[crop].topStart,
                                    topEnd = viewModel.homeCardList[crop].topEnd,
                                    bottomStart = viewModel.homeCardList[crop].bottomLeft,
                                    bottomEnd = viewModel.homeCardList[crop].bottomRight
                                ),
                            ) {
                                viewModel.homeCardList[crop].route?.let { route ->
                                    navController.navigate(route)
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp, vertical = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                        elevation = CardDefaults.cardElevation(10.dp),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = stringResource(id = R.string.take_a_picture),
                                    color = MaterialTheme.colorScheme.surfaceTint,
                                    fontSize = 14.sp,
                                    softWrap = true
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                Icon(
                                    painterResource(id = R.drawable.scan_leaf),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(30.dp)
                                )

                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowForward,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.surfaceTint,
                                    modifier = Modifier.size(30.dp)
                                )

                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = stringResource(id = R.string.get_diagnosis_and_remedies),
                                    color = MaterialTheme.colorScheme.surfaceTint,
                                    fontSize = 14.sp,
                                    softWrap = true
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                Icon(
                                    painterResource(id = R.drawable.remedies),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.surfaceTint,
                                    modifier = Modifier.size(30.dp)
                                )

                            }
                        }


                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val composition3 by rememberLottieComposition(
                            spec = LottieCompositionSpec.Asset("swipeup.json")
                        )
                        LottieAnimation(
                            composition = composition3,
                            iterations = Int.MAX_VALUE,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(start = 0.dp, top = 0.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.swipe_up_to_scan),
                            color = MaterialTheme.colorScheme.onError,
                            fontSize = 14.sp,
                            softWrap = true
                        )
                    }
                }
            }

        }

    }
}

@Composable
fun HomeScreenCard(
    image: Int,
    title: Int,
    isSelected: Boolean = false,
    shape: RoundedCornerShape,
    onClick: () -> Unit = {},
) {
    Box(modifier = Modifier) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = shape,
            modifier = Modifier
                .clickable {
                    onClick()
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = stringResource(id = title),
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = title),
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                )

            }
        }
        if (isSelected) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                Card(
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .padding(7.dp)
                            .size(22.dp),
                    )
                }
            }
        }

    }
}

data class HomeCard(
    val image: Int,
    val title: Int,
    var isSelected: Boolean = false,
    val topStart: Dp = 0.dp,
    val topEnd: Dp = 0.dp,
    val bottomLeft: Dp = 0.dp,
    val bottomRight: Dp = 0.dp,
    val route: String? = null
)

