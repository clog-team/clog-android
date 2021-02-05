package com.movie.it

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.movie.it.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val tabTextList = listOf("홈", "친구", "My")
    private val tabIconList = listOf(
        R.drawable.home,
        R.drawable.people,
        R.drawable.person,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setViewPager()
    }

    private fun setViewPager() {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        viewPager.adapter = MainFragmentStateAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTextList[position]
            tab.setIcon(tabIconList[position])
        }.attach()
        viewPager.isUserInputEnabled = false
    }

}