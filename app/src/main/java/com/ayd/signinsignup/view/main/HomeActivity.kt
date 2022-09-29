package com.ayd.signinsignup.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ayd.signinsignup.R
import com.ayd.signinsignup.databinding.ActivityHomeBinding
import com.ayd.signinsignup.view.fragments.HomeFragment
import com.ayd.signinsignup.view.fragments.SettingsFragment
import com.ayd.signinsignup.util.Constant.STATE_VALUE

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragments(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> fragments(HomeFragment())
                R.id.settings -> fragments(SettingsFragment())
            }
            true
        }





        val reciever = intent.getBooleanExtra(STATE_VALUE,false)

        if(!reciever){
            Toast.makeText(this,"Password not Saved!",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,"Password Saved!",Toast.LENGTH_SHORT).show()
        }




    }


    private fun fragments(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

    }


}