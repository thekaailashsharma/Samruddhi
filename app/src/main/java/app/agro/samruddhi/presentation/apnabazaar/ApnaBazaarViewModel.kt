package app.samruddhi.smartagro.presentation.apnabazaar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.apnabazaar.ui.BazaarCardItem
import app.agro.samruddhi.presentation.apnabazaar.ui.ChooseBazaar
import app.samruddhi.smartagro.presentation.login.ImageSlider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ApnaBazaarViewModel @Inject constructor() : ViewModel() {

    val chooseBazaarList: SnapshotStateList<ChooseBazaar> = mutableStateListOf()

    var sliderLists: SnapshotStateList<ImageSlider> = mutableStateListOf()
    var isAnimationPlaying: MutableState<Boolean> = mutableStateOf(false)
    val bazaarCardList: SnapshotStateList<BazaarCardItem> = mutableStateListOf()

    init {

        sliderLists.add(
            ImageSlider(
                image = R.drawable.apnabazar,
            )
        )
        sliderLists.add(
            ImageSlider(
                image = R.drawable.mittikman,
            )
        )
        sliderLists.add(
            ImageSlider(
                image = R.drawable.pashupalak,
            )
        )
        sliderLists.add(
            ImageSlider(
                image = R.drawable.weather,
            )
        )

        chooseBazaarList.add(
            ChooseBazaar(
                image = R.drawable.eqipments,
                title = R.string.equipments
            )
        )
        chooseBazaarList.add(
            ChooseBazaar(
                image = R.drawable.seeds,
                title = R.string.seeds,
                iconSize = 100.dp
            )
        )
        chooseBazaarList.add(
            ChooseBazaar(
                image = R.drawable.fertilizers,
                title = R.string.fertilizers,
                iconSize = 100.dp
            )
        )
        chooseBazaarList.add(
            ChooseBazaar(
                image = R.drawable.pesticides,
                title = R.string.pesticides
            )
        )

        bazaarCardList.add(
            BazaarCardItem(
                quantity = 10,
                price = "₹ 100",
                itemName = R.string.sonic,
                icon1 = Icons.Filled.Call,
                icon2 = Icons.Filled.Whatsapp
            )
        )
        bazaarCardList.add(
            BazaarCardItem(
                quantity = 10,
                price = "₹ 100",
                itemName = R.string.sonic,
                icon1 = Icons.Filled.Call,
                icon2 = Icons.Filled.Whatsapp
            )
        )
        bazaarCardList.add(
            BazaarCardItem(
                quantity = 10,
                price = "₹ 100",
                itemName = R.string.sonic,
                icon1 = Icons.Filled.Call,
                icon2 = Icons.Filled.Whatsapp
            )
        )
    }

}