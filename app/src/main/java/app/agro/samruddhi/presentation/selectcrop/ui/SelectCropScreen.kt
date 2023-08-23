package app.agro.samruddhi.presentation.selectcrop.ui

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.login.LoginViewModel
import app.agro.samruddhi.presentation.login.ui.LoginTopBar
import app.agro.samruddhi.presentation.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectCropScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            LoginTopBar(
                title = R.string.app_name,
                icon = R.drawable.lucide_wheat
            )
        },
    ) {
        Log.i("SelectCropScreen", "SelectCropScreen: ${viewModel.selectedCropsList.size}")
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        MaterialTheme.colorScheme.onPrimary
                    )
                    .padding(it)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                AnimatedVisibility(
                    visible = viewModel.selectedCropsList.size > 1,
                    enter = slideInVertically(tween(1000)),
                    exit = slideOutVertically(tween(1000))
                ) {
                    if (viewModel.selectedCropsList.size > 1) {
                        SelectedCropHeader(
                            selectedList = viewModel.selectedCropsList
                        )
                    }
                }
                SelectCropHeader()
                Spacer(modifier = Modifier.height(16.dp))
                SelectCropGrid(cropList = viewModel.selectCropsList, viewModel = viewModel)
            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                AnimatedVisibility(
                    visible = viewModel.selectedCropsList.size > 1,
                    enter = slideInVertically(
                        initialOffsetY = { fullHeight ->
                            fullHeight
                        },
                        animationSpec = tween(500)
                    ),
                    exit = slideOutVertically(
                        targetOffsetY = { fullHeight ->
                            fullHeight
                        },
                        animationSpec = tween(500)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 35.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                navController.navigate(Screens.Home.route)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            ),
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Text(
                                text = stringResource(id = R.string.next),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }
                }
            }
        }


    }

}


@Composable
fun SelectedCropHeader(selectedList: List<Crop?>) {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        items(selectedList) { crop ->
            if (crop?.isSelected == true) {
                Column {
                    Image(
                        painter = painterResource(id = crop?.image ?: R.drawable.banana),
                        contentDescription = stringResource(
                            id = crop?.title ?: R.string.banana
                        ),
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun SelectCropGrid(cropList: SnapshotStateList<Crop?>, viewModel: LoginViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.wrapContentHeight()
    ) {
        itemsIndexed(cropList) { index, crop ->
            SelectCropCard(
                image = crop?.image,
                title = crop?.title,
                isSelected = viewModel.selectCropsList[index]?.isSelected ?: false
            ) {
                viewModel.selectCropsList[index]?.isSelected =
                    !viewModel.selectCropsList[index]?.isSelected!!
                if (viewModel.selectCropsList[index]?.isSelected == true) {
                    viewModel.selectedCropsList.add(
                        Crop(
                            image = crop?.image ?: R.drawable.banana,
                            title = crop?.title ?: R.string.banana,
                            isSelected = true
                        )
                    )
                } else {
                    viewModel.selectedCropsList.remove(
                        Crop(
                            image = crop?.image ?: R.drawable.banana,
                            title = crop?.title ?: R.string.banana,
                            isSelected = true
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun SelectCropHeader(maxCropSelection: Int = 3) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.select_crop),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${stringResource(R.string.you_can_select_crop_upto)} $maxCropSelection",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp,
            )
        }

    }
}


@Composable
fun SelectCropCard(
    image: Int?,
    title: Int?,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
) {
    Box(modifier = Modifier) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(8.dp)
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
                    painter = painterResource(id = image ?: R.drawable.banana),
                    contentDescription = stringResource(id = title ?: R.string.banana),
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = title ?: R.string.banana),
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 25.sp
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

@Preview
@Composable
fun SelectCropCardPreview() {
    SelectCropCard(image = R.drawable.banana, title = R.string.banana)
}


data class Crop(
    val image: Int,
    val title: Int,
    var isSelected: Boolean = false
)