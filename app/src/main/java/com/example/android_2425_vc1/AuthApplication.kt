package com.example.android_2425_vc1

import android.app.Application
import com.example.android_2425_vc1.DI.AppContainer
import com.example.android_2425_vc1.DI.DefaultAppContainer

class AuthApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        //DI
        container = DefaultAppContainer(context = applicationContext)
    }
}