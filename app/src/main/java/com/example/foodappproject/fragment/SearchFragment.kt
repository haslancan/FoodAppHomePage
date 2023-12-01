package com.example.foodappproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodappproject.R
import com.example.foodappproject.adapter.MenuAdapter
import com.example.foodappproject.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName = listOf("Burger", "sandwich", "momo", "item", "sandwich", "momo", "sandwich", "momo", "item", "sandwich", "momo")
    private val originalMenuItemPrice = listOf("$5", "$6", "$8", "$9", "$10", "$10", "$6", "$8", "$9", "$10", "$10")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6
    )

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage, requireContext())
        binding.menuRecylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecylerView.adapter = adapter

        // show all menu Items
        showAllMenu()
        setupSearchView()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String?) {
        query?.let {
            filteredMenuFoodName.clear()
            filteredMenuItemPrice.clear()
            filteredMenuImage.clear()

            originalMenuFoodName.forEachIndexed { index, foodName ->
                if (foodName.contains(query, ignoreCase = true)) {
                    filteredMenuFoodName.add(foodName)
                    filteredMenuItemPrice.add(originalMenuItemPrice[index])
                    filteredMenuImage.add(originalMenuImage[index])
                }
            }
            adapter.notifyDataSetChanged()
        }
    }

    companion object {
    }
}