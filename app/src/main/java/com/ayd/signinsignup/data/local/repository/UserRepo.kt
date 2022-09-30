package com.ayd.signinsignup.data.local.repository

import androidx.lifecycle.LiveData
import com.ayd.signinsignup.data.local.dao.UserDao
import com.ayd.signinsignup.model.User
import javax.inject.Inject
import javax.inject.Singleton

//Repo class abstracts access to multi data source.
@Singleton
class UserRepo @Inject constructor(private val userDao: UserDao) {

    val readData: LiveData<List<User>> = userDao.getRead()

    suspend fun addUser(user: User){
        userDao.insert(user)
    }

}