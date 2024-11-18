package com.example.android_2425_vc1.network.auth0

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Auth0Api {

    /*
    * {"access_token":"eyJhbGci...","expires_in":86400,"token_type":"Bearer"}
    * */
    @FormUrlEncoded
    @POST("oauth/token")
    fun getAccessToken(
        @Field("username") userName: String,
        @Field("audience") audience: String, // =  "https://api.dozer.com"
        @Field("grant_type") grantType: String, // = "password"
        @Field("client_id") clientId: String, // = "ZHb11Q8Q5WbQaqKV0A09NbjyxadXHUia"
        @Field("password") pwd: String,

        ): Call<AuthorizeResponse>

//    @FormUrlEncoded
//    @POST("oauth/token")
//    suspend fun getCredentials(
//        @Field("username") userName: String,
//        @Field("password") password: String,
//        @Field("grant_type") grantType: String = "password",
//        @Field("client_id") clientId: String = "iy2aLVYpWuvnqdfpdcdBkiWQVmTKgjBB",
//    ): Call<AuthorizeResponse>

}