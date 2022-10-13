package com.ayd.weatherapp.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Daily(
    @SerializedName("clouds")
    val clouds: Int?,
    @SerializedName("dew_point")
    val dewPoint: Double?,
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("feels_like")
    val feelsLike: @RawValue FeelsLike?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("moon_phase")
    val moonPhase: Double?,
    @SerializedName("moonrise")
    val moonrise: Int?,
    @SerializedName("moonset")
    val moonset: Int?,
    @SerializedName("pop")
    val pop: Double?,
    @SerializedName("pressure")
    val pressure: Int?,
    @SerializedName("rain")
    val rain: Double?,
    @SerializedName("sunrise")
    val sunrise: Int?,
    @SerializedName("sunset")
    val sunset: Int?,
    @SerializedName("temp")
    val temp: @RawValue Temp?,
    @SerializedName("uvi")
    val uvi: Double?,
    @SerializedName("weather")
    val weather: @RawValue List<Weather>?,
    @SerializedName("wind_deg")
    val windDeg: Int?,
    @SerializedName("wind_gust")
    val windGust: Double?,
    @SerializedName("wind_speed")
    val windSpeed: Double?
): Parcelable