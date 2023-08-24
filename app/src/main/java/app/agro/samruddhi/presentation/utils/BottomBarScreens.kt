package app.agro.samruddhi.presentation.utils

import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.navigation.Screens

sealed class BottomBarScreens(val route: String?, val title: String?, val icon: Int) {
    data object HomeScreen : BottomBarScreens(
        Screens.Home.route,
        "Home",
        R.drawable.lucide_wheat
    )

    data object ProfileScreen : BottomBarScreens(
        Screens.Profile.route,
        "Profile",
        R.drawable.you
    )

    data object ScannerScreen : BottomBarScreens(
        Screens.ScanML.route,
        "Scanner",
        R.drawable.scan_leaf
    )

    data object ApnaBazaar : BottomBarScreens(
        Screens.ApnaBazaar.route,
        "Apna Bazaar",
        R.drawable.apnabazar
    )
}

val items = listOf(
    BottomBarScreens.HomeScreen,
    BottomBarScreens.ApnaBazaar,
    BottomBarScreens.ProfileScreen
)