package com.example.android_2425_vc1.screens.login

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.auth0.android.result.Credentials
import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.repository.APIResource
import com.example.android_2425_vc1.utils.ReplyContentType

@Composable
fun Login(
    login: (Credentials) -> Unit = {},
    contentType: ReplyContentType,
    modifier: Modifier = Modifier,
) {
    // Passing the login functionality to the VM
    val extras = MutableCreationExtras().apply {
        set(LoginViewModel.LOGIN_KEY, login)
        set(LoginViewModel.APPLICATION_KEY, LocalContext.current.applicationContext as Application)
    }
    val viewModel: LoginViewModel = viewModel(
        factory = LoginViewModel.Factory,
        extras = extras,
    )

    val loginState by viewModel.uiState.collectAsState()
    val apiResponseState by viewModel.authResponse.collectAsState()

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (contentType == ReplyContentType.LIST_AND_DETAIL) {
                ReplyListAndDetailContent(
                    loginState = loginState,
                    viewModel = viewModel,
                    apiResponseState = apiResponseState,
                    modifier = Modifier
                        .statusBarsPadding()
                        .weight(1f),
                )
            } else {
                ReplyListOnlyContent(
                    loginState = loginState,
                    viewModel = viewModel,
                    apiResponseState = apiResponseState,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun ReplyListOnlyContent(
    loginState: LoginState,
    viewModel: LoginViewModel,
    apiResponseState: APIResource<Credentials>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = WindowInsets.safeDrawing.asPaddingValues(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.logo_dozer_icon_no_text_cropped),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.dozer_title),
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                TextField(
                    value = loginState.username,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { viewModel.updateUserName(it) },
                    label = { Text(text = stringResource(id = R.string.username)) },
                    isError = loginState.loginError
                )

                Spacer(modifier = Modifier.height(16.dp))

                var passwordVisible by rememberSaveable { mutableStateOf(false) }
                PasswordField(
                    value = loginState.password,
                    isError = loginState.loginError,
                    onValueChange = { viewModel.updatePwd(it) },
                    passwordVisible = passwordVisible,
                    toggleVisible = { passwordVisible = !passwordVisible }
                )

                if (loginState.loginError && apiResponseState is APIResource.Error) {
                    ErrorMessage(apiResponseState)
                }
            }
        }

        item {
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { viewModel.onSubmit() },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_200))
                ) {
                    if (apiResponseState is APIResource.Loading) {
                        Text(stringResource(id = R.string.loading))
                    } else {
                        Text(
                            stringResource(id = R.string.login_button),
                            color = colorResource(id = R.color.black)
                        )
                    }
                }

                ForgotPassword()
            }
        }
    }
}

@Composable
fun ReplyListAndDetailContent(
    loginState: LoginState,
    viewModel: LoginViewModel,
    apiResponseState: APIResource<Credentials>,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp

    Row(
        modifier = modifier,
        horizontalArrangement =  Arrangement.SpaceEvenly
    ) {
        LazyColumn(
            contentPadding = WindowInsets.statusBars.asPaddingValues(),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.logo_dozer_icon_no_text_cropped),
                    contentDescription = null,
                    modifier = Modifier.size(screenHeightDp * 0.6f)
                )
            }

            item {
                Text(
                    text = stringResource(id = R.string.dozer_title),
                    fontWeight = FontWeight.Bold,
                    fontSize = 64.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

        LazyColumn(
            contentPadding = WindowInsets.statusBars.asPaddingValues(),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    TextField(
                        value = loginState.username,
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = { viewModel.updateUserName(it) },
                        label = { Text(text = stringResource(id = R.string.username)) },
                        isError = loginState.loginError
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    var passwordVisible by rememberSaveable { mutableStateOf(false) }
                    PasswordField(
                        value = loginState.password,
                        isError = loginState.loginError,
                        onValueChange = { viewModel.updatePwd(it) },
                        passwordVisible = passwordVisible,
                        toggleVisible = { passwordVisible = !passwordVisible }
                    )

                    if (loginState.loginError && apiResponseState is APIResource.Error) {
                        ErrorMessage(apiResponseState)
                    }
                }
            }

            item {
                Column(
                    Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { viewModel.onSubmit() },
                        modifier = Modifier.fillMaxWidth(0.8f),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_200))
                    ) {
                        if (apiResponseState is APIResource.Loading) {
                            Text(stringResource(id = R.string.loading))
                        } else {
                            Text(
                                stringResource(id = R.string.login_button),
                                color = colorResource(id = R.color.black)
                            )
                        }
                    }

                    ForgotPassword()
                }
            }
        }
    }
}

@Composable
fun ErrorMessage(apiResponse: APIResource<Credentials>) {
    if (apiResponse is APIResource.Error) {
        Text(
            text = stringResource(id = R.string.login_error_message) + apiResponse.message,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
fun PasswordField(
    value: String,
    isError: Boolean,
    onValueChange: (String) -> Unit,
    passwordVisible: Boolean,
    toggleVisible: () -> Unit
) {
    TextField(
        value = value,
        isError = isError,
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.password)) },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(onClick = { toggleVisible() }) {
                Icon(imageVector = image, contentDescription = description)
            }
        }
    )
}



