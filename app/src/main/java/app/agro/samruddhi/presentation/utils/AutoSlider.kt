package app.agro.samruddhi.presentation.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.agro.samruddhi.R
import app.samruddhi.smartagro.presentation.login.ImageSlider
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoSlider(
    sliderList: SnapshotStateList<ImageSlider>,
    isDotsVisible: Boolean = true,
    slidingSpeed: Long = 2000
) {
    val state = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        sliderList.size
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        SliderView(state, sliderList)
        Spacer(modifier = Modifier.padding(4.dp))
        if (isDotsVisible) {
            DotsIndicator(
                totalDots = sliderList.size,
                selectedIndex = state.currentPage
            )
        }

    }
    var nextPage by remember { mutableIntStateOf(1) }
    LaunchedEffect(key1 = nextPage) {
        delay(slidingSpeed)
        state.animateScrollToPage(nextPage).also { nextPage = (nextPage + 1) % 3 }
    }
}

@Composable
fun SliderView(
    state: PagerState,
    list: SnapshotStateList<ImageSlider>
) {
    val imageUrl = remember { mutableStateOf<Int?>(null) }
    HorizontalPager(
        state = state,
    ) { page ->
        imageUrl.value = list[page]?.image

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.TopCenter) {
                val painter = painterResource(imageUrl.value ?: R.drawable.slider1)
                Image(
                    painter = painter, contentDescription = "", Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Fit
                )
            }

        }


    }
}


@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.inversePrimary)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewAutoSlider() {
    AutoSlider(sliderList = remember {
        mutableStateListOf(
            ImageSlider(
                image = R.drawable.slider1,
            ),
            ImageSlider(
                image = R.drawable.slider2,
            ),
            ImageSlider(
                image = R.drawable.slider3,
            ),
        )
    })
}