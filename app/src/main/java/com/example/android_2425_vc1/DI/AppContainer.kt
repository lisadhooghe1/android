package com.example.android_2425_vc1.DI

import android.content.Context
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.network.auth0.Auth0Api
import com.example.android_2425_vc1.repository.Auth0Repo
import com.example.android_2425_vc1.repository.IAuthRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppContainer {
    val authApiService: Auth0Api
    val authRepo: IAuthRepo
}

/* container that takes care of dependencies
It creates the api service and injects it into the repo.
*/
class DefaultAppContainer(private val context: Context) : AppContainer {
    private val baseUrl = "https://${context.getString(R.string.com_auth0_domain)}"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .baseUrl(baseUrl)
        .build()


    //your own client
    override val authApiService: Auth0Api by lazy {
        retrofit.create(Auth0Api::class.java)
    }

    //the client provided by auth0
    var auth0: Auth0 = Auth0(context)
    var authentication: AuthenticationAPIClient = AuthenticationAPIClient(auth0)

    override val authRepo: IAuthRepo by lazy {
        Auth0Repo(authentication)
    }
}
