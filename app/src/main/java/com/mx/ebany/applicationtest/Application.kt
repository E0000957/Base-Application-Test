package com.mx.ebany.applicationtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application:Application(){
    override fun onCreate() {
        super.onCreate()
    }
}