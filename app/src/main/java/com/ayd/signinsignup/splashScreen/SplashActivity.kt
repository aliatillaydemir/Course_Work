package com.ayd.signinsignup.splashScreen

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import com.ayd.signinsignup.LoginActivity
import com.ayd.signinsignup.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fullScreenSplashScreen()  // = supportActionBar?.hide()
        splashScreenConfig()


    }



    private fun splashScreenConfig() {

        binding.apply {
            splash.alpha = 0f

            splash.animate().setDuration(2000).alpha(1f).withEndAction{
                val intent = Intent(this@SplashActivity,LoginActivity::class.java)
                startActivity(intent)

                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }

        }

    }



    private fun fullScreenSplashScreen() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())  // = supportActionBar?.hide()
        } else {  // for older devices
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

    }



}