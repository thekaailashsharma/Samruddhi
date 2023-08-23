package app.agro.samruddhi.presentation.login

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.AndroidViewModel
import app.agro.samruddhi.R
import app.samruddhi.smartagro.presentation.login.ImageSlider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val application: Application
) : AndroidViewModel(application) {

    var sliderLists: SnapshotStateList<ImageSlider> = mutableStateListOf()

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


    }
}