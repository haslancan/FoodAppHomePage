package com.example.foodappproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodappproject.databinding.ActivityDetalistBinding

class DetalistActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityDetalistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage",0)

        binding.detalistFoodName.text = foodName
        binding.detalidFoodImage.setImageResource(foodImage)

        binding.imageButton.setOnClickListener {
            finish()
        }
    }
}