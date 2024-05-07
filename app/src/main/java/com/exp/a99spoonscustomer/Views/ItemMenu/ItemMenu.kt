package com.exp.a99spoonscustomer.Views.ItemMenu

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.exp.a99spoonscustomer.adapter.MenuItemAdapter
import com.exp.a99spoonscustomer.databinding.ActivityItemMenuBinding
import com.exp.a99spoonscustomer.model.MenuItem

class ItemMenu : AppCompatActivity() {
    private lateinit var coursesGV: GridView
    lateinit var binding: ActivityItemMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityItemMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        val courseModelArrayList: ArrayList<MenuItem> = ArrayList()
        courseModelArrayList.add(
            MenuItem(
                "Vanilla Bean",
                "https://www.99spoons.com/wp-content/uploads/2022/08/Vanilla-Bean_Mockup_CupDesign-copy-1-2048x1365.jpg.webp"
            )
        )
        courseModelArrayList.add(
            MenuItem(
                "Strawberry",
                "https://www.99spoons.com/wp-content/uploads/2022/08/Strawberry_Mockup_CupDesign-copy-1-1-2048x1365.jpg.webp"
            )
        )
        courseModelArrayList.add(
            MenuItem(
                "Belgian Chocolate",
                "https://www.99spoons.com/wp-content/uploads/2022/08/Belgium-Chocolate_Mockup_CupDesign-copy-1-2048x1365.jpg.webp"
            )
        )
        courseModelArrayList.add(
            MenuItem(
                "Coconut",
                "https://www.99spoons.com/wp-content/uploads/2022/08/Coconut_Mockup_CupDesign-copy-2048x1365.jpg.webp"
            )
        )
        courseModelArrayList.add(
            MenuItem(
                "Mango",
                "https://www.99spoons.com/wp-content/uploads/2022/08/mango-_Mockup_CupDesign-2048x1365.jpg.webp"
            )
        )
        courseModelArrayList.add(
            MenuItem(
                "Coffee",
                "https://www.99spoons.com/wp-content/uploads/2022/08/Coffee_Mockup_CupDesign-copy-2048x1365.jpg.webp"
            )
        )
        courseModelArrayList.add(
            MenuItem(
                "Pistachio",
                "https://www.99spoons.com/wp-content/uploads/2022/08/Pistachio-_Mockup_CupDesign-2048x1365.jpg.webp"
            )
        )
        courseModelArrayList.add(
            MenuItem(
                "Yellow Cake Batter",
                "https://www.99spoons.com/wp-content/uploads/2022/08/Yellow-Cake-Batter_Mockup_CupDesign-copy-2048x1365.jpg.webp"
            )
        )
        val adapter = MenuItemAdapter(this, courseModelArrayList)
        binding.idGVcourses.adapter = adapter
        binding.popUpBack.setOnClickListener {
            onBackPressed()
        }
        setContentView(binding.root)
    }
}