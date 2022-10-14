package com.ayd.weatherapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ayd.weatherapp.repo.DataStoreRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application){  //repoyu okumak için viewmodel oluşturdum. Kayıt ve okuma işlemleri view'dan bağımısız olacak.

    private val repo = DataStoreRepo(application)


    val readDataStore = repo.readDataStore.asLiveData()   //flow'dan livedata'ya çeviriyoruz.

    //yazma okuma işlemlerini yapıyoruz(dispatcher io'da!). Coroutine scope kullanılıyor bunun için tabii ki, farklı threadler kullanılmalı.
     fun saveDataStore(lat: String) = viewModelScope.launch(Dispatchers.IO){
        repo.saveDataStore(lat)
    }

    val readDataStoreLon = repo.readDataStoreLon.asLiveData()

    fun saveDataStoreLon(lon: String) = viewModelScope.launch(Dispatchers.IO){
        repo.saveDataStoreLon(lon)
    }

}