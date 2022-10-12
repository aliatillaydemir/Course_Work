package com.ayd.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import coil.load
import com.ayd.weatherapp.data.ApiClient
import com.ayd.weatherapp.models.MainWeather
import com.ayd.weatherapp.models.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById<ImageView>(R.id.imageView)

        getInfo()

    }
    
    private fun getInfo() {
        ApiClient.getApiService().weatherQuery(41.015137,28.979530).enqueue(object :
            Callback<MainWeather> {
            override fun onResponse(call: Call<MainWeather>, response: Response<MainWeather>) {
                Log.d("deneme1", response.body().toString())

                //val resp: Response<Weather> = Response<Weather>()

                Log.d("deneme1", response.body()?.current?.weather?.get(0)?.icon.toString())
                val photo = response.body()?.current?.weather?.get(0)?.icon.toString()
                imageView.load("https://openweathermap.org/img/wn/${photo}@2x.png")


                if (response.isSuccessful) {
                    val everything = response.body()
                    everything?.let {
                        Log.d("deneme1", it.daily?.size.toString())
                    }
                }
            }

            override fun onFailure(call: Call<MainWeather>, t: Throwable) {
                Log.d("deneme1", t.toString())

            }
        })



    }


}