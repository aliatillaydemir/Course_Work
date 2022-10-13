package com.ayd.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ayd.weatherapp.R
import com.ayd.weatherapp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    private lateinit var lat: String
    private lateinit var longi: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       _binding = FragmentFirstBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.button.setOnClickListener{

            lat = binding.latitudeText.text.toString()
            longi = binding.longitudeText.text.toString()

            navController.navigate(R.id.action_firstFragment_to_homeFragment,Bundle().apply {
                putString("latitude",lat)
                putString("longitude",longi)
            })

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}