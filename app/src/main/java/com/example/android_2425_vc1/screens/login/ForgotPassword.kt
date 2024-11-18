package com.example.android_2425_vc1.screens.login

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.example.android_2425_vc1.R


/*
* This composable uses the auth0 webview.
* It's much less customizable, but faster in setup.
* */
@Composable
fun ForgotPassword() {
    val context = LocalContext.current
    val clientId = stringResource(R.string.com_auth0_client_id)
    val domain = stringResource(R.string.com_auth0_domain)

    TextButton(onClick = {
        val account = Auth0(clientId, domain)

        WebAuthProvider.login(account).withScheme(context.getString(R.string.com_auth0_scheme))
            .withScheme(context.getString(R.string.com_auth0_scheme))
            .withScope("openid profile email")
            .withAudience("https://${context.getString(R.string.com_auth0_domain)}/api/v2/")

            // Launch the authentication passing the callback where the results will be received
            .start(context, object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(exception: AuthenticationException) {
                    // Something went wrong!
                }

                // Called when authentication completed successfully
                override fun onSuccess(credentials: Credentials) {
                    // Get the access token from the credentials object.
                    // This can be used to call APIs
                    val accessToken = credentials.accessToken

                }
            })
    }) {
        Text(
            stringResource(id = R.string.forgot_password),
            color = colorResource(id = R.color.gray_500)
        )
    }
}



