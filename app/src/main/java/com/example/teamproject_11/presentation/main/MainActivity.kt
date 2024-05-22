package com.example.teamproject_11.presentation.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.teamproject_11.R
import com.example.teamproject_11.databinding.ActivityMainBinding
import com.example.teamproject_11.presentation.detail.DetailActivity
import com.example.teamproject_11.presentation.home.main.HomeViewModel
import com.example.teamproject_11.presentation.home.model.HomeVideoModel
import com.example.teamproject_11.presentation.myvideo.fragmentMode
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        initText()
        initViewPager()
        initToolBar()

    }

    private fun initViewPager() {


        val viewPager = binding.mainViewPager
        val tabLayout = binding.tablayout

        viewPager.run {
            isUserInputEnabled = false
        }

        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.home)
                }

                1 -> {
                    tab.text = "Search"
                    tab.setIcon(R.drawable.search)
                }

                2 -> {
                    tab.text = "My Videos"
                    tab.setIcon(R.drawable.video)
                }
            }
        }.attach()

        binding.tablayout.tabTextColors =
            ContextCompat.getColorStateList(this@MainActivity, R.color.tab_select_color)
        binding.tablayout.tabIconTint =
            ContextCompat.getColorStateList(this@MainActivity, R.color.tab_select_color)
    }

    private fun initToolBar() {
        with(binding) {
            val viewPager = mainViewPager
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> {
                            tvTbTitle.text = "Home"
                        }

                        1 -> {
                            tvTbTitle.text = "Search"
                        }

                        2 -> {
                            tvTbTitle.text = "My Videos"
                        }
                    }
                }
            })
            ivTbMain.setOnClickListener {
                val share = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "앱을 공유합니다!" +
                                "\n\n링크: https://play.google.com/store/app/details?id=com.example.teamproject_11" +
                                "\n\nGitHub: https://github.com/TeamProject11Media/TeamProject_Media"
                    )
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(share, null))
            }
        }
    }


    fun openVideoDetailFromHome(videoModel: HomeVideoModel) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("ClickItem", videoModel)
        startActivity(intent)

    }

    //여기에다가 사용하실 아이콘 등록해서 넣어주세요!
    private fun initText(){
        binding.ivTbMain.setOnLongClickListener {
            Log.d("모드 전환", "모드 전환")
            fragmentMode = 1
            viewModel.myvideoModeObserve()
            true
        }
    }
}
