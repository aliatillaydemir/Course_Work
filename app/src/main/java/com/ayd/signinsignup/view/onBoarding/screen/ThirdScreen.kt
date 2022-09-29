package com.ayd.signinsignup.view.onBoarding.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayd.signinsignup.view.LoginActivity
import com.ayd.signinsignup.databinding.FragmentThirdBinding


class ThirdScreen : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentThirdBinding.inflate(inflater, container, false)

        binding.finishText.setOnClickListener{

            startActivity(Intent(this.requireContext(), LoginActivity::class.java))
            isOnBoardingfinished()
        }


        return binding.root
    }

    private fun isOnBoardingfinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }


}