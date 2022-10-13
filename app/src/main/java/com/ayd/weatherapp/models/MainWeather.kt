package com.ayd.weatherapp.models


import com.google.gson.annotations.SerializedName

data class MainWeather(
    @SerializedName("current")
    val current: Current?,
    @SerializedName("daily")
    val daily: List<Daily>?,
    //@SerializedName("hourly")   //bu hourly'de hata veriyor, neden anlamadım ama bulacağım. aynı şekilde kullandığım liste dönen değişkenler var, gson hatası verme sebebi bulunmalı.
    //val hourly: List<Hourly>?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("minutely")
    val minutely: List<Minutely>?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int?
)