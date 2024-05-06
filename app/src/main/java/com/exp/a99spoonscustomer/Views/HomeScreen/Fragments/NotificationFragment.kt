package com.exp.a99spoonscustomer.Views.HomeScreen.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exp.a99spoonscustomer.adapter.NotificationAdapter
import com.exp.a99spoonscustomer.databinding.FragmentNotificationBinding
import com.exp.a99spoonscustomer.model.Notification

class NotificationFragment : Fragment() {
    lateinit var binding: FragmentNotificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBinding.inflate(layoutInflater)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewAdapter.layoutManager = layoutManager
        val adapter = NotificationAdapter(notificationData())
        binding.recyclerViewAdapter.adapter = adapter
        // Inflate the layout for this fragment
        return binding.root
    }

    fun notificationData(): List<Notification> {
        return listOf(
            Notification(
                title = "🚀 Hot Deals Inside!",
                subtitle = "Don't miss out on our latest promotions! Check out our exciting offers today."
            ),
            Notification(
                title = "New Arrival Alert!",
                subtitle = "Indulge in our latest flavors! Check out our new ice cream arrivals today."
            ),
            Notification(
                title = "Special Promo Inside!",
                subtitle = "Unlock exclusive discounts with promo code: SWEETDEAL. Limited time offer!"
            ),
            Notification(
                title = "Just In: Fresh Flavors!",
                subtitle = "Discover our newest ice cream flavors! Treat yourself to something delicious today."
            ),
            Notification(
                title = "Limited Time Promo!",
                subtitle = "Hurry! Use promo code: TASTYSCOOP for special discounts on select ice cream treats."
            ),
            Notification(
                title = "Just Arrived: Exciting Flavors!",
                subtitle = "Explore our latest ice cream arrivals! Try something new and delightful."
            ),
            Notification(
                title = "Exclusive Offer Inside!",
                subtitle = "Enjoy special savings with promo code: YUMMYDEAL. Don't miss out on these sweet deals!"
            ),
        )
    }
}