package com.exp.a99spoonscustomer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exp.a99spoonscustomer.databinding.ActivityUserProfileBinding

class UserProfile : AppCompatActivity() {
    lateinit var binding: ActivityUserProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        listners()
        setContentView(binding.root)
    }

    fun listners() {
        binding.popUpBack.setOnClickListener {
            onBackPressed()
        }
    }
}