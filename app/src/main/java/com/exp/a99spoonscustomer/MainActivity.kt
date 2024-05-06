package com.exp.a99spoonscustomer

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.exp.a99spoonscustomer.Views.HomeScreen.HomeActivity
import com.exp.a99spoonscustomer.Views.Splashscreen.SplashScreen


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                if (SpoonsApplication.sharedPreferencesManager.accessToken == null) {
                    val intent: Intent = Intent(this, SplashScreen::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    SpoonsApplication.sharedPreferencesManager.accessToken = "jinayshah"
                    val intent: Intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            },
            3000
        )

    }
}