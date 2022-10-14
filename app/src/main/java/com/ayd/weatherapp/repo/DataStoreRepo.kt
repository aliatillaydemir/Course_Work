package com.ayd.weatherapp.repo

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


const val PREFERENCE_KEY = "pref_key"

class DataStoreRepo(context: Context) {

    private val Context.dataStore by preferencesDataStore(name = PREFERENCE_KEY)

    private val dataStore = context.dataStore

    private object PrefKey{
        val lat = stringPreferencesKey("latitude")
    }

    suspend fun saveDataStore(latitude: String){
        dataStore.edit { pref ->
            pref[PrefKey.lat] = latitude
        }
    }

    val readDataStore: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }
        .map { pref ->
            val lat = pref[PrefKey.lat] ?: "no data"
            lat
        }


//longitudeeeeeeee

    private object PrefKeyLon{
        val lon = stringPreferencesKey("longitude")
    }

    suspend fun saveDataStoreLon(longitude: String){
        dataStore.edit { pref ->
            pref[PrefKeyLon.lon] = longitude
        }
    }

    val readDataStoreLon: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }
        .map { pref ->
            val lon = pref[PrefKeyLon.lon] ?: "no data"
            lon
        }






}