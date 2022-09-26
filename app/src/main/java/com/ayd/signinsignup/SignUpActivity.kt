package com.ayd.signinsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ayd.signinsignup.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
        }

        val mail = binding.editTextTextEmailAddress.text
        val password = binding.editTextTextPassword.text

        binding.registerButton.setOnClickListener {
            Toast.makeText(this,"mail: $mail, password: $password",Toast.LENGTH_SHORT).show()
        }


    }
}