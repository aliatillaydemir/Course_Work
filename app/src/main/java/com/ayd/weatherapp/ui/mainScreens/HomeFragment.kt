package com.ayd.weatherapp.ui.mainScreens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import coil.load
import com.ayd.weatherapp.R
import com.ayd.weatherapp.data.ApiClient
import com.ayd.weatherapp.databinding.FragmentHomeBinding
import com.ayd.weatherapp.models.MainWeather
import com.ayd.weatherapp.util.Constants.DETAIL_KEY
import com.ayd.weatherapp.util.Constants.LATITUDE
import com.ayd.weatherapp.util.Constants.LONGITUDE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(){  //ana fragment. Veriler ilk burada ekrana bastırılıyor.

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
            latitude = it.getString(LATITUDE).toString()
            longitude = it.getString(LONGITUDE).toString()
        }

        ApiClient.getApiService().weatherQuery(latitude.toDouble(),longitude.toDouble()).enqueue(object :
            Callback<MainWeather> {
            override fun onResponse(call: Call<MainWeather>, response: Response<MainWeather>) {
                //Log.d("deneme1", response.body().toString())
                //Log.d("deneme1", response.body()?.current?.weather?.get(0)?.icon.toString())


                if (response.isSuccessful) {
                    val myBody = response.body()
                    myBody?.let {

                        val photo = response.body()?.current?.weather?.get(0)?.icon.toString()
                        binding.specialImage.load("https://openweathermap.org/img/wn/${photo}@4x.png")

                        binding.textView2.text = response.body()?.timezone
                        binding.textView3.text = response.body()?.current?.weather?.get(0)?.description
                        binding.textView4.text = response.body()?.current?.feelsLike?.minus(273.15).toString().take(5)+ " C°"
                        binding.textView5.text = response.body()?.current?.pressure.toString() + " p"
                        binding.textView6.text = response.body()?.current?.humidity.toString() + " g/m3"
                        binding.windSpeed.text =response.body()?.current?.windSpeed.toString() + " m/s"
                        binding.windDeg.text =response.body()?.current?.windDeg.toString() + "°"
                        binding.uvi.text =response.body()?.current?.uvi.toString() + " UV"
                        binding.dewpoint.text =response.body()?.current?.dewPoint?.minus(273.15).toString().take(5) + " C°"
                    }
                }

                binding.specialImage.setOnClickListener {
                    navController.navigate(R.id.action_homeFragment_to_detailFragment, Bundle().apply {
                        putString(DETAIL_KEY,response.body()?.toJson())
                    })

                }

            }

            override fun onFailure(call: Call<MainWeather>, t: Throwable) {
                Log.d("deneme1", t.toString())
                Toast.makeText(context,"Connection error!",Toast.LENGTH_SHORT).show()
            }
        })



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}