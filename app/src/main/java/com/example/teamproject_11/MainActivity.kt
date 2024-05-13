package com.example.teamproject_11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.teamproject_11.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initViewPager()

    }

    private fun initViewPager() {
        var viewPager = binding.mainViewPager
        var tabLayout = binding.tablayout
        val tabIconArray = arrayOf(
            R.drawable.home,
            R.drawable.search,
            R.drawable.video
        )
        val tabTitleArray = arrayOf(
            "Home",
            "Search",
            "My Video"
        )

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager) { tab, position ->
            tab.icon = getDrawable(tabIconArray[position])
            tab.text = tabTitleArray[position]
        }.attach()
        binding.tablayout.tabTextColors =
            ContextCompat.getColorStateList(this@MainActivity, R.color.tab_select_color)
        binding.tablayout.tabIconTint =
            ContextCompat.getColorStateList(this@MainActivity, R.color.tab_select_color)
    }
}


