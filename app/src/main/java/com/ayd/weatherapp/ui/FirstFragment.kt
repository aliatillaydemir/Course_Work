package com.ayd.weatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ayd.weatherapp.R
import com.ayd.weatherapp.databinding.FragmentFirstBinding
import com.ayd.weatherapp.viewModel.MainViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    private lateinit var lat: String
    private lateinit var longi: String

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       _binding = FragmentFirstBinding.inflate(inflater,container,false)

        mainViewModel = ViewModelProvider(this.requireActivity())[MainViewModel::class.java]

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()


        mainViewModel.readDataStore.observe(this.requireActivity()) { lati ->
            println("deneme - lat: $lati") //işlemler
            lat = lati
        }

        mainViewModel.readDataStoreLon.observe(this.requireActivity()){ lon ->
            println("deneme - longi: $lon") //işlemler
            longi = lon
        }


        binding.button.setOnClickListener{

            if(binding.latitudeText.text.isNullOrBlank() && binding.longitudeText.text.isNullOrBlank()){
                //ikisi de boşsa datapreference ile gir(datastore verisi kayıtlı mı kontrolü olmalı tabii).
                //if(datastore kaydı yoksa -> bu bilgileri doldurmalısın!(uygulamaya ilk kez giriliyor.))
                //else(datastore verilerini gönder, bir önceki girilen verilerle home fragment kısmına girilsin.)

   /*              mainViewModel.readDataStore.observe(this.requireActivity()) { lati ->
                    println("deneme - lat: $lati") //işlemler
                    lat = lati
                    }

                mainViewModel.readDataStoreLon.observe(this.requireActivity()){ lon ->
                    println("deneme - longi: $lon") //işlemler
                    longi = lon
                    }*/


                    navController.navigate(R.id.action_firstFragment_to_homeFragment,Bundle().apply {
                        putString("latitude",lat)
                        putString("longitude",longi)
                    })


            }else if(binding.latitudeText.text.isNullOrBlank() && !binding.longitudeText.text.isNullOrBlank()){
                binding.latitudeText.error = "enlem bilgilerini doldurmalısın!"
            }else if(!binding.latitudeText.text.isNullOrBlank() && binding.longitudeText.text.isNullOrBlank()){
                binding.longitudeText.error = "boylam bilgilerini doldurmalısın!"
            }else{

                lat = binding.latitudeText.text.toString()
                longi = binding.longitudeText.text.toString()

                mainViewModel.saveDataStore(lat)
                mainViewModel.saveDataStoreLon(longi)

                navController.navigate(R.id.action_firstFragment_to_homeFragment,Bundle().apply {
                    putString("latitude",lat)
                    putString("longitude",longi)
                })

            }
            //koşul sonu

        }  //buton

    } //onViewCreated


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}