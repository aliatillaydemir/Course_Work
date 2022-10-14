package com.ayd.weatherapp.data

import com.ayd.weatherapp.models.MainWeather
import com.ayd.weatherapp.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.REST_URL)
    fun weatherQuery(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): Call<MainWeather>

}