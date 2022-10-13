package com.ayd.weatherapp.models

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class MainWeather(
    @SerializedName("current")
    val current: @RawValue Current?,   //bu classları da parcelize yap.
    @SerializedName("daily")
    val daily: @RawValue List<Daily>?,
    //@SerializedName("hourly")   //bu hourly'de hata veriyor, neden anlamadım ama bulacağım. aynı şekilde kullandığım liste dönen değişkenler var, gson hatası verme sebebi bulunmalı.
    //val hourly: List<Hourly>?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("minutely")
    val minutely: @RawValue List<Minutely>?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int?
): Parcelable {
    fun toJson(): String{
        return Gson().toJson(this)
    }
    companion object {
        fun fromJson(jsonValue: String): MainWeather {
            return Gson().fromJson(jsonValue, MainWeather::class.java)
        }
    }

}