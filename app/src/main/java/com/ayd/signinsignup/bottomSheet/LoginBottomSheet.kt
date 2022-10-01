package com.ayd.signinsignup.bottomSheet


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.ayd.signinsignup.databinding.FragmentLoginBottomSheetBinding
import com.ayd.signinsignup.view.loading.LoadingDialog
import com.ayd.signinsignup.view.main.HomeActivity
import com.ayd.signinsignup.util.Constant.STATE_VALUE
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentLoginBottomSheetBinding

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

        setOnClick()


    }


    private fun setOnClick() {

        val intent = Intent(requireContext(), HomeActivity::class.java)

        binding.yesButton.setOnClickListener {

            intent.putExtra(STATE_VALUE,true)
            waitAndGo(intent)
        }

        binding.noButton.setOnClickListener {

            intent.putExtra(STATE_VALUE,false)
            waitAndGo(intent)
        }

    }


    private fun waitAndGo(intent: Intent) {

        val loading = LoadingDialog(this.requireActivity())
        loading.startLoading()

        lifecycleScope.launch {
            launch {
                delay(2000)
                startActivity(intent)
                //loading.isDissmiss()
                activity?.onBackPressed()
            }

        }

    }



}