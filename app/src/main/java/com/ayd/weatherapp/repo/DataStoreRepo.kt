package com.ayd.weatherapp.repo

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ayd.weatherapp.util.Constants.LATITUDE
import com.ayd.weatherapp.util.Constants.LONGITUDE
import com.ayd.weatherapp.util.Constants.PREFERENCE_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


class DataStoreRepo(context: Context) {      //Data store ile veri kayıt ettiğimiz ve okuduğumuz repo. ViewModel ile iletişim halinde. UI bize uzak olsun.

    companion object{
        private val Context.dataStore by preferencesDataStore(name = PREFERENCE_KEY)  //bunu companion object'te singleton olarak tanımlamadığımda
    }//java.lang.IllegalStateException: There are multiple DataStores active for the same file hatası alıyorum. birden fazla datastore verisinin aynı file'da olması doğru değil. Singleton yapı oluşturarak sorun çözülüyor.


    private val dataStore = context.dataStore      //ulaştığımız data store contexti.

    //latitude için
    private object PrefKey{
        val lat = stringPreferencesKey(LATITUDE)
    }

    suspend fun saveDataStore(latitude: String){           //datastore'a kaydetmek için
        dataStore.edit { pref ->
            pref[PrefKey.lat] = latitude
        }
    }

    val readDataStore: Flow<String> = dataStore.data     //datastore'dan okumak için
        .catch { exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }
        .map { pref ->
            val lat = pref[PrefKey.lat] ?: "no data"     //henüz veri yoksa
            lat
        }


    //longitude için
    private object PrefKeyLon{
        val lon = stringPreferencesKey(LONGITUDE)
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