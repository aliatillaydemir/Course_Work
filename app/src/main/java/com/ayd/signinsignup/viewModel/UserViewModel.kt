package com.ayd.signinsignup.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ayd.signinsignup.data.local.UserDatabase
import com.ayd.signinsignup.data.local.repository.UserRepo
import com.ayd.signinsignup.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
//ui <-> repository
class UserViewModel @Inject constructor(application: Application): AndroidViewModel(application) {  //androidViewModel is different other ViewModel, cause it take application as parameter.
//Aslında @Inject construtor içinde userRepo olup bir modül classı açılır. bu modül @Module ve @InstallIn(AppComponent::class) ile annote edilmelidir
    //daha sonra  @Provides ve @Singleton annotasyonları ile provide db fonksiyonu yazılıp buildir kurulur. Doğru yapı bu şekilde kurulur.
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









