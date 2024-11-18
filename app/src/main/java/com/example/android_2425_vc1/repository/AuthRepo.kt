package com.example.android_2425_vc1.repository

import com.auth0.android.result.Credentials
import com.example.android_2425_vc1.network.auth0.AuthorizeResponse
import kotlinx.coroutines.flow.Flow


interface IAuthRepo {
    suspend fun getToken(userName: String, password: String): Flow<APIResource<AuthorizeResponse>>

    suspend fun getCredentials(userName: String, password: String): Flow<APIResource<Credentials>>
}

//
//class AuthRepo(val authApi: Auth0Api) : IAuthRepo {
//
//    /*
//    * getToken performs the api call asynchronously using a Call and Response system
//    * Don't confuse the response with an APIResource.
//    *
//    * When the response contains 'successfull' an APIResource object is created to hold the data
//    * the APIResource is then emitted on a flow, ready to be collected.
//    * */
//    override suspend fun getToken(userName: String, password: String) =
//        flow<APIResource<AuthorizeResponse>> {
//            val loadingResource = APIResource.Loading<AuthorizeResponse>()
//            emit(loadingResource)
//
//            val call = authApi.getAccessToken(userName = userName, pwd = password)
//
//            //converting the call to a flow by executing as a synchronized function
//            val response =
//                withContext(Dispatchers.IO) {
//                    call.execute()
//                }
//
//            if (response.isSuccessful) {
//                val token = response.body()
//
//                // Check if the student object is null due to parsing issues
//                if (token != null) {
//                    Log.d("API", "Token: ${token.access_token}")
//                    emit(APIResource.Success<AuthorizeResponse>(token))
//                } else {
//                    Log.e("API", "Failed to parse token object, response ok")
//                    // Fallback: Handle the case when parsing fails
//                    emit(
//                        APIResource.Error<AuthorizeResponse>(
//                            "Issue when loggin in." + response.errorBody()?.string()
//                        )
//                    )
//
//                }
//            } else {
//                Log.e("Error", "API call unsuccessful: ${response.errorBody()?.string()}")
//                emit(
//                    APIResource.Error<AuthorizeResponse>(
//                        "Issue with API call" + response.errorBody()?.string()
//                    )
//                )
//            }
//
//
//        }.flowOn(Dispatchers.IO)
//
//    override suspend fun getCredentials(
//        userName: String,
//        password: String
//    ): Flow<APIResource<Credentials>> = flow {
//        // Emit a loading state initially
//        emit(APIResource.Loading<Credentials>())
//
//        try {
//            // Make the API call using the Auth0 API
//            val response = withContext(Dispatchers.IO) {
//                authApi.getCredentials(userName, password).execute()
//            }
//
//            // Check if the response is successful
//            if (response.isSuccessful) {
//                val credentials = response.body()
//
//                if (credentials != null) {
//                    emit(APIResource.Success<Credentials>(credentials))
//                } else {
//                    emit(APIResource.Error<Credentials>("Failed to parse credentials from the response"))
//                }
//            } else {
//                // If the response was not successful, emit an error with details
//                emit(
//                    APIResource.Error<Credentials>(
//                        "Authentication failed: ${response.errorBody()?.string()}"
//                    )
//                )
//            }
//        } catch (e: Exception) {
//            // Handle any exception and emit it as an error
//            Log.e("AuthRepo", "Error fetching credentials", e)
//            emit(APIResource.Error<Credentials>("An error occurred: ${e.message}"))
//        }
//    }.flowOn(Dispatchers.IO)
//
//
//}
//
//
