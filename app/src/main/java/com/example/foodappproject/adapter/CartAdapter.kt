package com.example.foodappproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappproject.databinding.CartItemBinding

class CartAdapter(private val cartItems:MutableList<String>,private val cartItemPrice:MutableList<String>,private val CartImage:MutableList<Int>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size


    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantitiy = itemQuantities[position]
                cartFoodName.text = cartItems[position]
                cartTemPrice.text = cartItemPrice[position]
                cartMage.setImageResource(CartImage[position])
                catItemQuantitiy.text = quantitiy.toString()

                minusButton.setOnClickListener {
                    deceaseQuantitiy(position)

                }
                pluseButton.setOnClickListener {
                    increaseQuantitiy(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition)
                    }
                }
            }
        }

        private fun increaseQuantitiy(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.catItemQuantitiy.text = itemQuantities[position].toString()
            }
        }

        private fun deceaseQuantitiy(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.catItemQuantitiy.text = itemQuantities[position].toString()
            }
        }

        private fun deleteItem(position: Int) {
            cartItems.removeAt(position)
            CartImage.removeAt(position)
            cartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)

            }
        }
    }



