package com.example.swipetorefresh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swipetorefresh.data.Users
import com.example.swipetorefresh.databinding.SingleItemBinding

class UserAdapter(private val clickListener : ClickListener) : ListAdapter<Users, UserAdapter.ViewHolder>(DiffCallback) {


    class ViewHolder(private val binding:  SingleItemBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun binding(parent: ViewGroup): ViewHolder {
                return ViewHolder(SingleItemBinding.inflate(LayoutInflater.from(parent.context)))
            }
        }

        // add the user data in to the xml file inside data binding...
        fun onBind(data: Users) {
            binding.data = data
            binding.executePendingBindings()
        }

    }


    companion object DiffCallback : DiffUtil.ItemCallback<Users>(){
        override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.binding(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.onBind(user)
        holder.itemView.setOnClickListener {
            clickListener.onclick(user)
        }

    }


    class ClickListener(val clickListener : (click : Users) -> Unit){
        fun onclick(userData: Users) = clickListener(userData)
    }


}