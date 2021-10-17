package com.example.swipetorefresh.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.swipetorefresh.data.Users
import kotlinx.coroutines.*

class MainScreenViewModel: ViewModel() {


    private var _list = MutableLiveData<MutableList<Users>>()
    val list: LiveData<MutableList<Users>> = _list


    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress


    private val scope = CoroutineScope(Dispatchers.Main + Job())



    init {

        _progress.value = false
        _list.value = ArrayList()
    }

    fun addData(data: Users){
        scope.launch {
            _list.value!!.add(data)
            _list.value = _list.value
            _progress.value = false
        }
    }




    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}