package com.example.swipetorefresh.util

import android.annotation.SuppressLint
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swipetorefresh.adapter.UserAdapter
import com.example.swipetorefresh.data.Users

class UtilBinding {


    companion object {

        @JvmStatic
        @BindingAdapter("dataList")
        fun recyclerViewUsers(recyclerView: RecyclerView,data: MutableList<Users>?){
            val adapter = recyclerView.adapter as UserAdapter
            adapter.submitList(data)
            adapter.notifyDataSetChanged()
        }

    }


}