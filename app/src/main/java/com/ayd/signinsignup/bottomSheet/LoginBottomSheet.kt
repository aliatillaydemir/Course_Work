package com.ayd.signinsignup.bottomSheet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.ayd.signinsignup.MainViewModel
import com.ayd.signinsignup.databinding.FragmentLoginBottomSheetBinding
import com.ayd.signinsignup.loading.LoadingDialog
import com.ayd.signinsignup.main.HomeActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class LoginBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: FragmentLoginBottomSheetBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBottomSheetBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.yesButton.setOnClickListener {
            waitAndGo()
        }

        binding.noButton.setOnClickListener {
            waitAndGo()
        }


    }

    private fun waitAndGo() {

        val loading = LoadingDialog(this.requireActivity())
        loading.startLoading()

        lifecycleScope.launch {
            launch {
                delay(2000)
                //loading.isDissmiss()
            }
            launch {
                delay(2000)
                startActivity(Intent(context, HomeActivity::class.java))
                activity?.onBackPressed()
            }
        }


    }

}