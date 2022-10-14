package com.ayd.weatherapp.ui.walkthrough.onBoardingScreens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.ayd.weatherapp.R
import com.ayd.weatherapp.databinding.FragmentFirstScreenBinding
import com.ayd.weatherapp.databinding.FragmentSecondScreenBinding
import com.ayd.weatherapp.databinding.FragmentThirdScreenBinding

class ThirdScreen : Fragment() {

    private var _binding: FragmentThirdScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)


        binding.finish.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_firstFragment)
            onBoardFinish()
        }

        return binding.root
    }


    private fun onBoardFinish(){
        val sharedPref = requireActivity().getSharedPreferences("onBoard", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}