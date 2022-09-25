package com.ayd.signinsignup


import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import com.ayd.signinsignup.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    var seeToPass: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButton.setOnClickListener {
        startActivity(Intent(this@LoginActivity,SignUpActivity::class.java))
        }

/*
        binding.iconToSee.setOnClickListener {
            if(!seeToPass) {
                seeToPass = true
                binding.iconToSee.setBackgroundResource(R.drawable.ic_see)

            }else{
                seeToPass = false
                binding.iconToSee.setBackgroundResource(R.drawable.no_see)

            }

        }
*/


    }



}