package com.ayd.signinsignup


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayd.signinsignup.bottomSheet.LoginBottomSheet
import com.ayd.signinsignup.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val bottomSheetFragment = LoginBottomSheet()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signupButton.setOnClickListener {
        startActivity(Intent(this@LoginActivity,SignUpActivity::class.java))
        }


        binding.loginButton.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"BottomSheet")
        }



    }



}