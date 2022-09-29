package com.ayd.signinsignup.view.onBoarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.ayd.signinsignup.R
import com.ayd.signinsignup.databinding.FragmentFirstBinding
import com.ayd.signinsignup.databinding.FragmentSecondBinding

class SecondScreen : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentSecondBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.nextText2.setOnClickListener{
            viewPager?.currentItem = 2  // 0-1-2. 1 is second index, so that means the next page.
        }

        return binding.root
    }


}