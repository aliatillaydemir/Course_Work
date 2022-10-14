package com.ayd.weatherapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ayd.weatherapp.repo.DataStoreRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application){

    private val repo = DataStoreRepo(application)


    val readDataStore = repo.readDataStore.asLiveData()

     fun saveDataStore(lat: String) = viewModelScope.launch(Dispatchers.IO){
        repo.saveDataStore(lat)
    }

    val readDataStoreLon = repo.readDataStoreLon.asLiveData()

    fun saveDataStoreLon(lon: String) = viewModelScope.launch(Dispatchers.IO){
        repo.saveDataStoreLon(lon)
    }

}