package com.exp.a99spoonscustomer.Views.PromotionScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exp.a99spoonscustomer.Views.PromotionScreen.data.PromotionData
import com.exp.a99spoonscustomer.adapter.PromoAdapter
import com.exp.a99spoonscustomer.databinding.ActivityPromotionScreenBinding

class PromotionScreen : AppCompatActivity() {
    lateinit var binding: ActivityPromotionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPromotionScreenBinding.inflate(layoutInflater)
        setListners()
        setAdapter()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun setAdapter() {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewAdapter.layoutManager = layoutManager
        val adapter = PromoAdapter(PromotionData.promoCodeData())
        binding.recyclerViewAdapter.adapter = adapter
    }

    private fun PromotionScreen.setListners() {
        binding.popUpBack.setOnClickListener { onBackPressed() }
    }
}