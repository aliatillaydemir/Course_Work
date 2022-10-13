package com.ayd.weatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import coil.load
import com.ayd.weatherapp.R
import com.ayd.weatherapp.data.ApiClient
import com.ayd.weatherapp.databinding.FragmentHomeBinding
import com.ayd.weatherapp.models.MainWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var latitude: String
    private lateinit var longitude: String

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        getInfo()

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

    }



    private fun getInfo() {


        arguments?.let {
            latitude = it.getString("latitude").toString()
            longitude = it.getString("longitude").toString()
        }

        ApiClient.getApiService().weatherQuery(latitude.toDouble(),longitude.toDouble()).enqueue(object :
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

                        binding.textView2.text = response.body()?.timezone
                        binding.textView3.text = response.body()?.current?.weather?.get(0)?.description
                        binding.textView4.text = response.body()?.current?.feelsLike.toString()
                        binding.textView5.text = response.body()?.current?.pressure.toString()
                        binding.textView6.text = response.body()?.current?.humidity.toString()
                    }
                }

                binding.specialImage.setOnClickListener {
                    navController.navigate(R.id.action_homeFragment_to_detailFragment, Bundle().apply {
                        putString("detail",response.body()?.toJson())
                    })

                }

            }

            override fun onFailure(call: Call<MainWeather>, t: Throwable) {
                Log.d("deneme1", t.toString())

            }
        })



    }




}