package com.merttoptas.retrofittutorial.data.di

import com.merttoptas.retrofittutorial.data.local.database.PostsDatabase
import com.merttoptas.retrofittutorial.data.remote.api.ApiService
import com.merttoptas.retrofittutorial.data.remote.api.UserService
import com.merttoptas.retrofittutorial.data.repository.PostRepository
import com.merttoptas.retrofittutorial.data.repository.PostRepositoryImpl
import com.merttoptas.retrofittutorial.data.repository.UserRepository
import com.merttoptas.retrofittutorial.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
class UserModule {
    // Api Service Class
    // Repository and DataSource Impl
    // Database

    @Provides
    fun provideApiService(retrofit: Retrofit) : UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun providePostRepository(userService: UserService) : UserRepository {
        return UserRepositoryImpl(userService)
    }
}