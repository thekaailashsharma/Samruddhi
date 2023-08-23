package app.agro.samruddhi.presentation.navigation

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object SelectCrop : Screens("selectCrop")
}