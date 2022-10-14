package com.ayd.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import coil.load
import com.ayd.weatherapp.data.ApiClient
import com.ayd.weatherapp.models.MainWeather
import com.ayd.weatherapp.models.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

    }


}