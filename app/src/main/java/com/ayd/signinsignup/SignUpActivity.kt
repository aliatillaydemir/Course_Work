package com.ayd.signinsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ayd.signinsignup.data.local.UserDatabase
import com.ayd.signinsignup.databinding.ActivitySignUpBinding
import com.ayd.signinsignup.model.User
import com.ayd.signinsignup.viewModel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    //private lateinit var userdb: UserDatabase

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //userdb = UserDatabase.getDb(this) //it is important.
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]  //userViewModel initializing

        binding.backButton.setOnClickListener {
            startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
        }

        binding.registerButton.setOnClickListener {
            writeData()
        }


    }

    private fun writeData() {

        val mail = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()
        val username = binding.editTextTextPersonName.text.toString()

        if(mail.isNotEmpty() && password.isNotEmpty()){
            val user = User(null,mail,password,username)
            mUserViewModel.addUser(user)
            Toast.makeText(this@SignUpActivity,"You have successfully registered!",Toast.LENGTH_SHORT).show()

            binding.editTextTextEmailAddress.text.clear()
            binding.editTextTextPassword.text.clear()
            binding.editTextTextPersonName.text.clear()

        }else{
            Toast.makeText(this@SignUpActivity,"it is empty",Toast.LENGTH_SHORT).show()
        }

        }




    }




