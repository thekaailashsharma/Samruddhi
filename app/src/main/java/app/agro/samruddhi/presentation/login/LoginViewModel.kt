package app.agro.samruddhi.presentation.login

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.home.ui.HomeCard
import app.agro.samruddhi.presentation.login.ui.SignInState
import app.agro.samruddhi.presentation.navigation.Screens
import app.agro.samruddhi.presentation.selectcrop.ui.Crop
import app.agro.samruddhi.presentation.utils.SignInResult
import app.agro.samruddhi.presentation.utils.TranslatorCardItem
import app.samruddhi.smartagro.presentation.login.ImageSlider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val application: Application
) : AndroidViewModel(application) {

    var sliderLists: SnapshotStateList<ImageSlider> = mutableStateListOf()
    var selectCropsList: SnapshotStateList<Crop?> = mutableStateListOf(null)
    var homeCardList: MutableList<HomeCard> = mutableListOf()
    var selectedCropsList: SnapshotStateList<Crop> = mutableStateListOf()

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    val translateList: SnapshotStateList<TranslatorCardItem> = mutableStateListOf()


    fun onSignInResult(result: SignInResult) {
        _state.update {
            it.copy(
                isSignInSuccessful = result.data != null,
                signInError = result.errorMessage
            )
        }
    }

    fun resetState() {
        _state.update { SignInState() }
    }

    init {
        sliderLists.add(
            ImageSlider(
                image = R.drawable.slider1,
            )
        )
        sliderLists.add(
            ImageSlider(
                image = R.drawable.slider2,
            )
        )
        sliderLists.add(
            ImageSlider(
                image = R.drawable.slider3,
            )
        )

        selectCropsList.add(
            Crop(
                image = R.drawable.banana,
                title = R.string.banana
            )
        )
        selectCropsList.add(
            Crop(
                image = R.drawable.ear_of_corn,
                title = R.string.maize
            )
        )
        selectCropsList.add(
            Crop(
                image = R.drawable.cotton,
                title = R.string.cotton
            )
        )
        selectCropsList.add(
            Crop(
                image = R.drawable.sugarcane,
                title = R.string.sugarcane
            )
        )
        selectCropsList.add(
            Crop(
                image = R.drawable.rice,
                title = R.string.rice
            )
        )
        selectCropsList.add(
            Crop(
                image = R.drawable.wheat,
                title = R.string.wheat
            )
        )
        selectCropsList.add(
            Crop(
                image = R.drawable.grapes,
                title = R.string.grapes
            )
        )
        homeCardList.add(
            HomeCard(
                image = R.drawable.weather,
                title = R.string.weather,
                topStart = 40.dp,
                route = Screens.Weather.route
            )
        )
        homeCardList.add(
            HomeCard(
                image = R.drawable.apnabazar,
                title = R.string.apnaBazar,
                topEnd = 40.dp
            )
        )
        homeCardList.add(
            HomeCard(
                image = R.drawable.mittikman,
                title = R.string.mittikmann,
                bottomLeft = 40.dp
            )
        )
        homeCardList.add(
            HomeCard(
                image = R.drawable.pashupalak,
                title = R.string.pashupalak,
                bottomRight = 40.dp
            )
        )

        translateList.add(
            TranslatorCardItem(
                title = "English",
                description = "English",
                locale = "en",
            )
        )
        translateList.add(
            TranslatorCardItem(
                title = "हिंदी",
                description = "Hindi",
                locale = "hi",
            )
        )
        translateList.add(
            TranslatorCardItem(
                title = "मराठी",
                description = "Marathi",
                locale = "mr",
            )
        )
        translateList.add(
            TranslatorCardItem(
                title = "ಕನ್ನಡ",
                description = "Kannada",
                locale = "kn",
            )
        )
        translateList.add(
            TranslatorCardItem(
                title = "தமிழ்",
                description = "Tamil",
                locale = "ta",
            )
        )
        translateList.add(
            TranslatorCardItem(
                title = "తెలుగు",
                description = "Malayalam",
                locale = "ml",
            )
        )
        translateList.add(
            TranslatorCardItem(
                title = "తెలుగు",
                description = "Telugu",
                locale = "te",
            )
        )


    }
}