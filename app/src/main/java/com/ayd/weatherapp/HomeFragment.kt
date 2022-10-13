package com.ayd.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.ayd.weatherapp.data.ApiClient
import com.ayd.weatherapp.databinding.FragmentHomeBinding
import com.ayd.weatherapp.models.MainWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        getInfo()

        return binding.root
    }

/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getInfo()
    }
*/

/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getInfo()
    }*/

    private fun getInfo() {
        ApiClient.getApiService().weatherQuery(41.015137,28.979530).enqueue(object :
            Callback<MainWeather> {
            override fun onResponse(call: Call<MainWeather>, response: Response<MainWeather>) {
                Log.d("deneme1", response.body().toString())

                //val resp: Response<Weather> = Response<Weather>()

                Log.d("deneme1", response.body()?.current?.weather?.get(0)?.icon.toString())
                val photo = response.body()?.current?.weather?.get(0)?.icon.toString()
                binding.specialImage.load("https://openweathermap.org/img/wn/${photo}@2x.png")


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