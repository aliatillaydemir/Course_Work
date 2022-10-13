package com.ayd.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.ayd.weatherapp.R
import com.ayd.weatherapp.databinding.FragmentDetailBinding
import com.ayd.weatherapp.models.MainWeather


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

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
            val details = it.getString("detail")

            details?.let {
                val detail = MainWeather.fromJson(it)


                val photo = detail.current?.weather?.get(0)?.icon.toString()
                binding.imageView.load("https://openweathermap.org/img/wn/${photo}@2x.png")

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