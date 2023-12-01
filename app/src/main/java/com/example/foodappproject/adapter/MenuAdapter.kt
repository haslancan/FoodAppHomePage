package com.example.foodappproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappproject.DetalistActivity
import com.example.foodappproject.databinding.MenuItemBinding

@Suppress("DEPRECATION")
class MenuAdapter(
    private val menuItemsName: List<String>,
    private val menuItemsPrice: List<String>,
    private val MenuImage: List<Int>,
    private val requireContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(requireContext, DetalistActivity::class.java)
                    intent.putExtra("MenuItemName", menuItemsName[position])
                    intent.putExtra("MenuItemImage", MenuImage[position])
                    requireContext.startActivity(intent)
                }
            }
        }

        fun bind(position: Int) {
            binding.apply {
                menufoodName.text = menuItemsName[position]
                menuPrice.text = menuItemsPrice[position]
                menuImage.setImageResource(MenuImage[position])
            }
        }
    }
}

