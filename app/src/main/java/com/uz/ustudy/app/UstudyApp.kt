package com.uz.ustudy.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UstudyApp : Application() {
    companion object {
        lateinit var application: Context

    }

    override fun onCreate() {
        super.onCreate()

        application = this.applicationContext
    }
}