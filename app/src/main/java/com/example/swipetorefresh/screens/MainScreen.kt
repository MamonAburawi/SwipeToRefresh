package com.example.swipetorefresh.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.swipetorefresh.R
import com.example.swipetorefresh.adapter.UserAdapter
import com.example.swipetorefresh.data.Users
import com.example.swipetorefresh.databinding.MainScreenBinding
import kotlin.random.Random


class MainScreen : Fragment() {
    private lateinit var binding: MainScreenBinding

    private lateinit var viewModel: MainScreenViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.main_screen,container,false)
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainScreenViewModel::class.java)

        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel

        binding.apply {




            // click on item..
            recycleView.adapter = UserAdapter(UserAdapter.ClickListener{
                Toast.makeText(activity,it.name,Toast.LENGTH_SHORT).show()
            })


            viewModel.progress.observe(viewLifecycleOwner, Observer {
                if(it){

                }else{
                    swipeRefreshLayout.isRefreshing = false
                }
            })


            swipeRefreshLayout.setOnRefreshListener {
                viewModel.addData(Users(1,"ahmed"))
            }


        }




        return binding.root
    }

}