package com.example.foodappproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappproject.databinding.LotifactionItemBinding

class NotifactionAdapter(private var notifaction: List<String>, private var notifactionImage: List<Int>) : RecyclerView.Adapter<NotifactionAdapter.NotifactionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifactionViewHolder {
        val binding = LotifactionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotifactionViewHolder(binding)
    }



    override fun onBindViewHolder(holder: NotifactionViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = notifaction.size

    inner class NotifactionViewHolder(private val binding: LotifactionItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notifactionTextView.text = notifaction[position]
                notifactionImageView.setImageResource(notifactionImage[position])
            }
        }

    }
}