package com.ayd.signinsignup.splashScreen

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import com.ayd.signinsignup.view.LoginActivity
import com.ayd.signinsignup.databinding.ActivitySplashBinding
import com.ayd.signinsignup.util.Constant.BOARD
import com.ayd.signinsignup.util.Constant.FINISHED_INT
import com.ayd.signinsignup.view.onBoarding.ViewPagerFragment

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
                //val intent = Intent(this@SplashActivity,LoginActivity::class.java)
                //val intent = Intent(this@SplashActivity, ViewPagerFragment::class.java)
                //startActivity(intent)
                onBoardingStatus()

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




    private fun onBoardingStatus() {

        if(isOnBoardingfinished()){
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        }else{
            startActivity(Intent(this@SplashActivity,ViewPagerFragment::class.java))
        }

    }



    private fun isOnBoardingfinished(): Boolean{
        val sharedPref = this.getSharedPreferences(BOARD, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(FINISHED_INT, false)  //default value is false
    }



}