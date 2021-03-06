package com.example.assessmentapplication.ui.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentapplication.databinding.ItemContactBinding
import com.example.assessmentapplication.util.Contact

class ContactsAdapter(private val item: List<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.Viewholder>() {

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
        holder.binding.tvTitle.text = item[position].firstName + " " + item[position].lastName
        holder.binding.clContainer.setOnClickListener {
            val action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(item[holder.adapterPosition])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}