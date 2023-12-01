package com.example.foodappproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodappproject.PayOutActivity
import com.example.foodappproject.R
import com.example.foodappproject.adapter.CartAdapter
import com.example.foodappproject.databinding.FragmentCarthBinding

class CarthFragment : Fragment() {
    private lateinit var binding: FragmentCarthBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarthBinding.inflate(inflater, container, false)

        val cartFoodName = mutableListOf("Burger", "sandwich", "momo", "item", "sandwich", "momo")
        val cartItemPrice = mutableListOf("$5", "$6", "$8", "$9", "$10", "$10") // Fix the last item
        val cartImage = mutableListOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6
        )

        if (cartFoodName.isNotEmpty() && cartItemPrice.isNotEmpty() && cartImage.isNotEmpty()) {
            cartAdapter = CartAdapter(cartFoodName, cartItemPrice, ArrayList(cartImage))
            binding.cartRecylerView.layoutManager = LinearLayoutManager(requireContext())
            binding.cartRecylerView.adapter = cartAdapter
        }

        binding.proocedButton.setOnClickListener {
            val intent = Intent(requireActivity(), PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}