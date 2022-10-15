package com.ayd.weatherapp.ui.walkthrough.onBoardingScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.ayd.weatherapp.R
import com.ayd.weatherapp.databinding.FragmentFirstScreenBinding
import com.ayd.weatherapp.databinding.FragmentSecondScreenBinding

class SecondScreen : Fragment() {     //2. onboard ekran

    private var _binding: FragmentSecondScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondScreenBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)  //view pager'a ulaşmak için findViewByid kullandım.

        binding.next2Button.setOnClickListener{
            viewPager?.currentItem = 2
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}