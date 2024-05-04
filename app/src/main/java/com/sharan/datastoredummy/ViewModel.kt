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

    fun getData(instance: StoreData) {
        viewModelScope.launch {
            get.value = instance.getData("key").toString()
        }
    }

    fun setData(instance : StoreData){
        viewModelScope.launch {
            instance.setData("key",str.value)
        }
    }
}