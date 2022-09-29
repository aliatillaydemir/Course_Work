package com.ayd.signinsignup.view.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.ayd.signinsignup.databinding.FragmentViewPagerBinding
import com.ayd.signinsignup.view.onBoarding.screen.FirstScreen
import com.ayd.signinsignup.view.onBoarding.screen.SecondScreen
import com.ayd.signinsignup.view.onBoarding.screen.ThirdScreen

class ViewPagerFragment : AppCompatActivity() {

    private lateinit var binding:FragmentViewPagerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter


    }


}