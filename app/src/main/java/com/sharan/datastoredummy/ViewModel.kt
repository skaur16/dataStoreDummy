package com.sharan.datastoredummy

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharan.datastoredummy.dataStorage.StoreData
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    var str = mutableStateOf("")
    var show = mutableStateOf(false)
    var get = mutableStateOf("")

    fun getData(context : Context){
        viewModelScope.launch {
            get.value = StoreData.create(context).getData("key").toString()
        }
    }

    fun setData(context : Context){
        viewModelScope.launch {
            StoreData.create(context).setData("key",str.value)
        }
    }
}