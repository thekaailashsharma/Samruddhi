package app.agro.samruddhi.presentation.utils

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import app.agro.samruddhi.MainActivity
import app.agro.samruddhi.data.DataStore
import kotlinx.coroutines.launch
import java.util.Locale


@Composable
fun TranslatorSheet(
    bottomSheetState: BottomSheetScaffoldState,
    translatorList: List<TranslatorCardItem>,
    content: @Composable () -> Unit
) {
    BottomSheetScaffold(
        sheetContent = {
            TranslatorSheetContent(
                list = translatorList,
                bottomSheetState = bottomSheetState,
            )
        },
        sheetContainerColor = MaterialTheme.colorScheme.onPrimary,
        scaffoldState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetPeekHeight = 0.dp,
    ) {
        content()
    }
}


@Composable
fun TranslatorSheetContent(
    list: List<TranslatorCardItem>,
    bottomSheetState: BottomSheetScaffoldState,
) {
    val coroutineScope = rememberCoroutineScope()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(list) {
            TranslatorCard(
                title = it.title,
                description = it.description,
                locale = it.locale
            ) {
                it.onClick()
                coroutineScope.launch {
                    bottomSheetState.bottomSheetState.hide()
                }
            }
        }
    }
}


@Composable
fun TranslatorCard(
    title: String,
    description: String,
    locale: String,
    onClick: () -> Unit
) {
    Box(modifier = Modifier) {
        val context = LocalContext.current
        val datastore = DataStore(context = context)
        val coroutineScope = rememberCoroutineScope()
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    coroutineScope.launch {
                        datastore.saveLocale(locale = locale)
                    }
                    val myLocale = Locale(locale)
                    val res: Resources = context.resources
                    val dm = res.displayMetrics
                    val conf: Configuration = res.configuration
                    conf.locale = myLocale
                    res.updateConfiguration(conf, dm)
                    val refresh = Intent(context, MainActivity::class.java)
                    startActivity(context, refresh, null)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 25.sp
                )

            }
        }
    }
}

@Preview
@Composable
fun PreviewTranslator() {
    TranslatorCard(
        title = "Sonic",
        description = "Hello",
        locale = "en",
        onClick = {}
    )
}

data class TranslatorCardItem(
    val title: String,
    val description: String,
    val locale: String,
    val onClick: () -> Unit = {}
)