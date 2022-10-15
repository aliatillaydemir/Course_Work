package com.ayd.weatherapp.ui.walkthrough.onBoardingScreens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ayd.weatherapp.R
import com.ayd.weatherapp.databinding.FragmentThirdScreenBinding
import com.ayd.weatherapp.util.Constants.FINISHED
import com.ayd.weatherapp.util.Constants.ONBOARD

class ThirdScreen : Fragment() {   //3. tanıtım ekranı

    private var _binding: FragmentThirdScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)


        binding.finishButton.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_firstFragment)  //finish'e tıklanırsa first fragment'a gidilir.
            onBoardFinish()
        }

        return binding.root
    }


    private fun onBoardFinish(){        //shared pref ile cihazda onboard ile tanıtımın bittiği boolean true olarak ifade ediliyor. Bir daha gözükmeyecek.
        val sharedPref = requireActivity().getSharedPreferences(ONBOARD, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(FINISHED,true)
        editor.apply()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}