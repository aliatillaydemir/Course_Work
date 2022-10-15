package com.ayd.weatherapp.ui.mainScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.ayd.weatherapp.databinding.FragmentDetailBinding
import com.ayd.weatherapp.models.MainWeather
import com.ayd.weatherapp.util.Constants.DETAIL_KEY
import com.denzcoskun.imageslider.models.SlideModel

//verilerin parcelize olarak iletildiği class. Kısaca yazdırılıyorlar, başka bir şey yapılmıyor.
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var imageList: ArrayList<SlideModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        arguments?.let {
            val details = it.getString(DETAIL_KEY)

            details?.let {
                val detail = MainWeather.fromJson(it)


                val photo = detail.current?.weather?.get(0)?.icon.toString()
                binding.imageView.load("https://openweathermap.org/img/wn/${photo}@2x.png")

                val weather0 = detail.daily?.get(0)?.weather?.get(0)?.icon.toString()
                val weather1 = detail.daily?.get(1)?.weather?.get(0)?.icon.toString()
                val weather2 = detail.daily?.get(2)?.weather?.get(0)?.icon.toString()
                val weather3 = detail.daily?.get(3)?.weather?.get(0)?.icon.toString()
                val weather4 = detail.daily?.get(4)?.weather?.get(0)?.icon.toString()
                val weather5 = detail.daily?.get(5)?.weather?.get(0)?.icon.toString()
                val weather6 = detail.daily?.get(6)?.weather?.get(0)?.icon.toString()
                val weather7 = detail.daily?.get(7)?.weather?.get(0)?.icon.toString()


                imageList = ArrayList()
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather0}@2x.png",detail.daily?.get(0)?.weather?.get(0)?.description))
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather1}@2x.png",detail.daily?.get(1)?.weather?.get(0)?.description))
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather2}@2x.png",detail.daily?.get(2)?.weather?.get(0)?.description))
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather3}@2x.png",detail.daily?.get(3)?.weather?.get(0)?.description))
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather4}@2x.png",detail.daily?.get(4)?.weather?.get(0)?.description))
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather5}@2x.png",detail.daily?.get(5)?.weather?.get(0)?.description))
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather6}@2x.png",detail.daily?.get(6)?.weather?.get(0)?.description))
                imageList.add(SlideModel("https://openweathermap.org/img/wn/${weather7}@2x.png",detail.daily?.get(7)?.weather?.get(0)?.description))

                binding.imageSlider.setImageList(imageList)

                binding.textView7.text = detail.timezone
                binding.textView8.text = detail.daily?.get(0)?.moonPhase.toString()
                binding.textView9.text = detail.current?.weather?.get(0)?.description.toString()
                binding.textView10.text = detail.current?.clouds.toString()
            }


        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}