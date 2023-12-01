package com.example.foodappproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodappproject.adapter.NotifactionAdapter
import com.example.foodappproject.databinding.FragmentNotifactionBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotifactionBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotifactionBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotifactionBottomBinding.inflate(inflater, container, false)

        val notifaction = listOf(
            "Your order has been Canceled Successfully",
            "Order has been taken by the driver",
            "Congrats Your Order Placed"
        )
        val notifactionImage = listOf(R.drawable.sademoji, R.drawable.truck, R.drawable.congrats)

        val adapter = NotifactionAdapter(notifaction, notifactionImage)

        binding.notifactionRecylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notifactionRecylerView.adapter = adapter

        return binding.root
    }
}