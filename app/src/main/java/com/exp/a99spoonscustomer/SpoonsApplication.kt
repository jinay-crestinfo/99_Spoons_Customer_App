package com.exp.a99spoonscustomer

import android.app.Application
import com.exp.a99spoonscustomer.Utils.SharedPreferencesManager

class SpoonsApplication :  Application() {
    companion object {
        lateinit var sharedPreferencesManager: SharedPreferencesManager
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferencesManager = SharedPreferencesManager(this)
    }
}