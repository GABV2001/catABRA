package edu.ni.abra.view

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp:Application() {

    override fun onCreate() {
        super.onCreate()
    }

}