package com.ayd.weatherapp.ui.walkthrough.onBoardingScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.ayd.weatherapp.R
import com.ayd.weatherapp.databinding.FragmentFirstScreenBinding


class FirstScreen : Fragment() {      //ilk onBoard ekranımız.

    private var _binding: FragmentFirstScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstScreenBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)  //view pager'a ulaşmak için findViewByid kullandım. Çünkü farklı bir fragment'ın xml dosyası.

        binding.nextText.setOnClickListener{
            viewPager?.currentItem = 1           //bu sayfayı geçince 2. ekrana(Second Screen'e) gidilir. Eleman pozisyonları 0-1-2 şeklinde ifade edililir.
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}