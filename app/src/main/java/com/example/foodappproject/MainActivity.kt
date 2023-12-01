package com.example.foodappproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodappproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         // Initialize the navController property
              val  navController = findNavController(R.id.fragmentContainerView)
              val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
               bottomNav.setupWithNavController(navController)

        binding.notifactionButton.setOnClickListener {
            val bottomSheetDialog = NotifactionBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }


    }
}





