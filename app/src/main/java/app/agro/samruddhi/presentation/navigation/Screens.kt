package app.agro.samruddhi.presentation.navigation

sealed class Screens(val route: String) {
    data object Login : Screens("login")
    data object SelectCrop : Screens("selectCrop")
    data object Home : Screens("home")
    data object ApnaBazaar : Screens("apnaBazaar")
    data object ScanML : Screens("scanML")
    data object Profile : Screens("profile")
    data object Weather : Screens("weather")
    data object ChooseUserType : Screens("chooseUserType")
    data object FarmerApnaBazaar : Screens("farmerApnaBazaar")
    data object BuyerApnaBazaar : Screens("buyerApnaBazaar")
    data object BuyerList : Screens("buyerList")
    data object FarmerList : Screens("farmerList")
    data object ConfirmBuyer : Screens("confirmBuyer")
}