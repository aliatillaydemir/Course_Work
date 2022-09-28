package com.ayd.signinsignup.data.local.repository

import androidx.lifecycle.LiveData
import com.ayd.signinsignup.data.local.dao.UserDao
import com.ayd.signinsignup.model.User

//Repo class abstracts access to multi data source.

class UserRepo(private val userDao: UserDao) {

    val readData: LiveData<List<User>> = userDao.getRead()

    suspend fun addUser(user: User){
        userDao.insert(user)
    }

}