package com.exp.a99spoonscustomer.Views.HomeScreen

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.exp.a99spoonscustomer.MainActivity
import com.exp.a99spoonscustomer.R
import com.exp.a99spoonscustomer.SpoonsApplication
import com.exp.a99spoonscustomer.UserProfile
import com.exp.a99spoonscustomer.Views.HomeScreen.Fragments.HomeFragment
import com.exp.a99spoonscustomer.Views.HomeScreen.Fragments.LocationFragment
import com.exp.a99spoonscustomer.Views.HomeScreen.Fragments.NotificationFragment
import com.exp.a99spoonscustomer.databinding.ActivityHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    private val homeFragment = HomeFragment()
    private val notificationFragment = NotificationFragment()
    private val locationFragment = LocationFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding.drawerIcon.setOnClickListener {
            binding.main.openDrawer(GravityCompat.START)
        }
        setContentView(binding.root)
        setCurrentFragment(homeFragment)
        setScreenIndicator(1)
        setNavDrawer()
        binding.logoutButton.setOnClickListener {
            signOut()
        }
        bottomNavBarListener()
    }

    private fun setNavDrawer() {
        val headerView = binding.navView.getHeaderView(0)
        val username = headerView.findViewById<TextView>(R.id.user_name)
        username.text = SpoonsApplication.sharedPreferencesManager.userName
        val userEmail = headerView.findViewById<TextView>(R.id.user_email)
        userEmail.text = SpoonsApplication.sharedPreferencesManager.email

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.hrms_drawer_userprofile -> {
                    val intent = Intent(this, UserProfile::class.java)
                    startActivity(intent)
                    false
                }

                else -> false
            }
        }
    }

    private fun bottomNavBarListener() {
        binding.tab1.setOnClickListener {
            setCurrentFragment(homeFragment)
            setScreenIndicator(1)
        }
        binding.tab2.setOnClickListener {
            setCurrentFragment(locationFragment)
            setScreenIndicator(2)
        }
        binding.tab3.setOnClickListener {
            setCurrentFragment(notificationFragment)
            setScreenIndicator(3)
        }

    }

    private fun setScreenIndicator(currentScreen: Int) {
        when (currentScreen) {
            1 -> {
                binding.tab1.setColorFilter(
                    ContextCompat.getColor(this, R.color.selected_icon),
                    PorterDuff.Mode.SRC_IN
                )
                binding.tab2.setColorFilter(
                    ContextCompat.getColor(this, R.color.unselected_icon),
                    PorterDuff.Mode.SRC_IN
                )
                binding.icon.setColorFilter(
                    ContextCompat.getColor(this, R.color.unselected_icon),
                    PorterDuff.Mode.SRC_IN
                )

            }

            2 -> {
                binding.tab2.setColorFilter(
                    ContextCompat.getColor(this, R.color.selected_icon),
                    PorterDuff.Mode.SRC_IN
                )
                binding.tab1.setColorFilter(
                    ContextCompat.getColor(this, R.color.unselected_icon),
                    PorterDuff.Mode.SRC_IN
                )
                binding.icon.setColorFilter(
                    ContextCompat.getColor(this, R.color.unselected_icon),
                    PorterDuff.Mode.SRC_IN
                )


            }

            3 -> {
                binding.icon.setColorFilter(
                    ContextCompat.getColor(this, R.color.selected_icon),
                    PorterDuff.Mode.SRC_IN
                )
                binding.tab2.setColorFilter(
                    ContextCompat.getColor(this, R.color.unselected_icon),
                    PorterDuff.Mode.SRC_IN
                )
                binding.tab1.setColorFilter(
                    ContextCompat.getColor(this, R.color.unselected_icon),
                    PorterDuff.Mode.SRC_IN
                )


            }

        }
    }

    private fun signOut() {
        try {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Sure You want to SignOut ?")
            builder.setTitle("Alert !")
            builder.setCancelable(false)
            builder.setPositiveButton(
                "Yes"
            ) { dialog: DialogInterface?, which: Int ->
                SpoonsApplication.sharedPreferencesManager.accessToken = null
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            builder.setNegativeButton(
                "No"
            ) { dialog: DialogInterface, which: Int ->
                dialog.cancel()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        } catch (e: Exception) {
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_error_view)
            bottomSheetDialog.findViewById<TextView>(R.id.error_message)?.text =
                "Failed to Sign out! Try again."
            bottomSheetDialog.findViewById<androidx.cardview.widget.CardView>(R.id.cancel_button)
                ?.setOnClickListener {
                    bottomSheetDialog.cancel()
                }
            bottomSheetDialog.show()
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}