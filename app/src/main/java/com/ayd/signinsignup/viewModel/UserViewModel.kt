package com.ayd.signinsignup.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ayd.signinsignup.data.local.UserDatabase
import com.ayd.signinsignup.data.local.repository.UserRepo
import com.ayd.signinsignup.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//ui <-> repository
class UserViewModel(application: Application): AndroidViewModel(application) {  //androidViewModel is different other ViewModel, cause it take application as parameter.

    val readData: LiveData<List<User>>
    private val repo: UserRepo

    init {
        val userDao = UserDatabase.getDb(application).userDao()
        repo = UserRepo(userDao)
        readData = repo.readData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addUser(user)
        }
    }

}