package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.model.Users
import com.merttoptas.retrofittutorial.data.remote.api.UserService
import retrofit2.Call

class UserRepositoryImpl constructor(private val userService: UserService): UserRepository {

    override fun getUser(): Call<List<Users>> {
        return userService.getUsers()
    }

}