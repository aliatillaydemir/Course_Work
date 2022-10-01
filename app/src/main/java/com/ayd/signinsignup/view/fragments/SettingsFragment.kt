package com.ayd.signinsignup.view.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.ayd.signinsignup.R
import com.ayd.signinsignup.databinding.FragmentSettingsBinding
import com.ayd.signinsignup.util.Constant

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)


        val language = resources.getStringArray(R.array.Languages)

        val spinner = binding.spinner

        if(spinner != null) {
            val adapter = ArrayAdapter(
                this.requireContext(),
                android.R.layout.simple_spinner_item, language
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(requireContext(), getString(R.string.selected_item) + " " + "" + language[position], Toast.LENGTH_SHORT).show()


                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }



  /*      binding.switch1.setOnCheckedChangeListener { button, isCheck ->

            val sharedPref = requireActivity().getSharedPreferences("dark_mode",Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            if(isCheck){
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("dark", true)
                editor.apply()
            }else{
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("dark", false)
                editor.apply()
            }

        }*/



        return binding.root
    }



}