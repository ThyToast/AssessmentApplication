package com.example.assessmentapplication.ui.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentapplication.databinding.ItemContactBinding

class ContactsAdapter(val item: List<Any>) : RecyclerView.Adapter<ContactsAdapter.Viewholder>() {

    class Viewholder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.tvTitle
    }

    override fun getItemCount(): Int {
        return item.size
    }
}