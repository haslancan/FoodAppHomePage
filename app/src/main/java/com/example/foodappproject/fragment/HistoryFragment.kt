package com.example.foodappproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodappproject.R
import com.example.foodappproject.adapter.BuyAgainAdapter
import com.example.foodappproject.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val buyAgainFoodName = mutableListOf("Food 2", "Food 2", "Food 3")
        val buyAgainFoodPrice = mutableListOf("$10", "$0", "$30")
        val buyAgainFoodImage = mutableListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.buyAgainRecylerView.adapter = buyAgainAdapter
        binding.buyAgainRecylerView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
    }
}