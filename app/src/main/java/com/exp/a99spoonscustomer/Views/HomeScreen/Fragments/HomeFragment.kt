package com.exp.a99spoonscustomer.Views.HomeScreen.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exp.a99spoonscustomer.R
import com.exp.a99spoonscustomer.Views.ItemMenu.ItemMenu
import com.exp.a99spoonscustomer.Views.PromotionScreen.PromotionScreen
import com.exp.a99spoonscustomer.adapter.CorouselView
import com.exp.a99spoonscustomer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setCourouselAdapter()
        setListners()
        return binding.root
    }

    private fun setCourouselAdapter() {
        val arrayList = ArrayList<Int>()
        arrayList.add(R.drawable.slider_1)
        arrayList.add(R.drawable.slider_2)
        arrayList.add(R.drawable.slider_3)
//        arrayList.add(R.drawable.slider_4)
        val adapter = CorouselView(arrayList)
        binding.recycler.setAdapter(adapter)
    }

    fun setListners() {
        binding.dashTab1.setOnClickListener {
            val intent = Intent(activity, ItemMenu::class.java)
            startActivity(intent)
        }
        binding.dashTab2.setOnClickListener {
            val intent = Intent(activity, PromotionScreen::class.java)
            startActivity(intent)
        }
    }

}