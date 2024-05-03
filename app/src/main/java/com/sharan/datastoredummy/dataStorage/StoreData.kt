package com.sharan.datastoredummy.dataStorage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import java.io.File

class StoreData(private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>) {

    companion object{

        fun create(context : Context) : StoreData{
            val datastore = PreferenceDataStoreFactory.create {
                File(context.filesDir, " dataStorage/StoreData.preferences_pb")
            }
            return StoreData(
                datastore
            )

        }
    }

    suspend inline fun  getData(key : String) : String?{
        val str = getSerializedData(key)
            ?: return null
        return Gson().fromJson(str, String::class.java)
    }

    suspend inline fun <reified T> setData(key : String, value : T){
        setSerializedData(key, Gson().toJson(value))
    }

    @PublishedApi
    internal suspend fun getSerializedData(key : String) : String?{
        return dataStore.data.first()[stringPreferencesKey(key)]
    }

    @PublishedApi
    internal suspend fun setSerializedData(key : String, value : String){
        dataStore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }



}