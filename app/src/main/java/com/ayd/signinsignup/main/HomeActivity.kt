package com.ayd.signinsignup.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ayd.signinsignup.R
import com.ayd.signinsignup.util.Constant.STATE_VALUE

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val reciever = intent.getBooleanExtra(STATE_VALUE,false)

        if(!reciever){
            Toast.makeText(this,"Password not Saved!",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Password Saved!",Toast.LENGTH_SHORT).show()
        }




    }
}