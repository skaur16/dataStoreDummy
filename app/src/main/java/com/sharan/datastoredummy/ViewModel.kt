package com.sharan.datastoredummy

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharan.datastoredummy.dataStorage.StoreData
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    var str = mutableStateOf("")
    var show = mutableStateOf(false)
    var get = mutableStateOf("")
    var list = mutableStateListOf<Objects>()
    var getList = mutableStateListOf<ObjectsList>()
    var objects = mutableStateOf(Objects())
    var objectsList = mutableStateOf(ObjectsList())

    fun getData(instance: StoreData) {
        viewModelScope.launch {
            objectsList = instance.getData("key")!! as MutableState<ObjectsList>
        }
    }

    fun setData(instance : StoreData){
        viewModelScope.launch {
            instance.setData("key",list)
        }
    }
}
