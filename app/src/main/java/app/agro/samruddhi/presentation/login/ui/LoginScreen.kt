package app.agro.samruddhi.presentation.login.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.agro.samruddhi.R
import app.agro.samruddhi.presentation.utils.AutoSlider
import app.samruddhi.smartagro.presentation.login.LoginViewModel
import app.samruddhi.smartagro.presentation.login.ui.LoginTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    var name = remember { mutableStateOf("") }
    var phoneNumber = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            LoginTopBar(
                title = R.string.app_name,
                icon = R.drawable.lucide_wheat
            )
        },
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(
                    MaterialTheme.colorScheme.onPrimary
                )
                .padding(it)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            AutoSlider(sliderList = loginViewModel.sliderLists)
            Spacer(modifier = Modifier.height(60.dp))
            LoginButton(name = name, phoneNumber = phoneNumber)
            Divider(
                color = MaterialTheme.colorScheme.outline,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 40.dp, start = 40.dp, end = 40.dp, bottom = 20.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialLoginButton(
                    imageVector = R.drawable.google,
                    text = stringResource(id = R.string.google)
                ) {
                    navController.navigate(Screens.SelectCrop.route)
                }

            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginButton(name: MutableState<String>, phoneNumber: MutableState<String>) {
    val iconSize = 65.dp
    val offsetInPx = LocalDensity.current.run { (iconSize / 0.68f).roundToPx() }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(15.dp),
                ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.name),
                            color = MaterialTheme.colorScheme.surfaceTint,
                            fontSize = 18.sp
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        focusedTextColor = MaterialTheme.colorScheme.surfaceTint
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = phoneNumber.value,
                    onValueChange = {
                        phoneNumber.value = it
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.phone_number),
                            color = MaterialTheme.colorScheme.surfaceTint,
                            fontSize = 18.sp
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        focusedTextColor = MaterialTheme.colorScheme.surfaceTint
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset {
                    IntOffset(x = 0, y = -offsetInPx)
                },
            contentAlignment = Alignment.TopCenter
        ) {
            Icon(
                painter = painterResource(id = R.drawable.group),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Composable
fun SocialLoginButton(
    imageVector: Int,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 40.dp, vertical = 20.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(15.dp),
            )
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)) {
            Icon(
                painter = painterResource(id = imageVector),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                color = MaterialTheme.colorScheme.surfaceTint,
                fontSize = 22.sp
            )
        }


    }
}


@Preview
@Composable
fun SocialLoginButtonPreview() {
    SocialLoginButton(
        imageVector = R.drawable.google,
        text = stringResource(id = R.string.google)
    ) {

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview()
@Composable
fun LoginButtonPreview() {
    LoginButton(name = mutableStateOf(""), phoneNumber = mutableStateOf(""))
}







