package com.merttoptas.retrofittutorial.data.remote.api

import com.merttoptas.retrofittutorial.data.model.Post
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by merttoptas on 8.10.2022.
 */

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

/*    @GET("users")
    fun getUsers(): Call<List<Users>>

    @DELETE("posts/{id}")
    fun deletePost(@Path("{id}") id: String): Call<Post>*/
}
