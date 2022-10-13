package com.ayd.weatherapp.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Current(
    @SerializedName("clouds")
    val clouds: Int?,
    @SerializedName("dew_point")
    val dewPoint: Double?,
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("feels_like")
    val feelsLike: Double?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("pressure")
    val pressure: Int?,
    @SerializedName("sunrise")
    val sunrise: Int?,
    @SerializedName("sunset")
    val sunset: Int?,
    @SerializedName("temp")
    val temp: Double?,
    @SerializedName("uvi")
    val uvi: Double?,
    @SerializedName("visibility")
    val visibility: Int?,
    @SerializedName("weather")
    val weather: @RawValue List<Weather?>?,
    @SerializedName("wind_deg")
    val windDeg: Int?,
    @SerializedName("wind_speed")
    val windSpeed: Double?
): Parcelable