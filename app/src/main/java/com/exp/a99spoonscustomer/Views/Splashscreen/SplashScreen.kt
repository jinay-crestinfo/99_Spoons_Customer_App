package com.exp.a99spoonscustomer.Views.Splashscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.exp.a99spoonscustomer.SpoonsApplication
import com.exp.a99spoonscustomer.Views.HomeScreen.HomeActivity
import com.exp.a99spoonscustomer.databinding.ActivitySplashScreenBinding
import me.relex.circleindicator.CircleIndicator

class SplashScreen : AppCompatActivity() {


    val RC_SIGN_IN: Int = 1

    var currentIndex: Int = 0
    var binding: ActivitySplashScreenBinding? = null
    var indicator: CircleIndicator? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        indicator = binding?.indicator
        indicator?.createIndicators(listOfPages.size, 0);
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        binding?.splashScreenImage?.setImageResource(listOfPages[currentIndex].drawableImage)
        binding?.splashScreenText?.text = listOfPages[currentIndex].description
        binding?.floatingActionButton?.setOnClickListener {
            if (currentIndex < listOfPages.size - 1) {
                currentIndex++;
                indicator?.animatePageSelected(currentIndex)
            }
            if (currentIndex == listOfPages.size - 1) {
                binding?.floatingActionButton?.visibility = View.GONE
                binding?.googleSignIn?.visibility = View.VISIBLE
            }
            binding?.splashScreenImage?.setImageResource(listOfPages[currentIndex].drawableImage)
            binding?.splashScreenText?.text = listOfPages[currentIndex].description
        }
        binding?.googleSignIn?.setOnClickListener { signIn() }
    }


    private fun signIn() {
        val intent: Intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        SpoonsApplication.sharedPreferencesManager.email = "shahjinay02@gmail.com"
        SpoonsApplication.sharedPreferencesManager.accessToken = "jinayshah"
        SpoonsApplication.sharedPreferencesManager.userName = "Jinay Shah"
        finish()
    }


}