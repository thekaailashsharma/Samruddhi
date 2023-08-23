package app.samruddhi.smartagro.presentation.login

data class ImageSlider(
    val name: String? = null,
    val image: Int,
    val desc: String? = null,
    val onClick: () -> Unit = {}
)
