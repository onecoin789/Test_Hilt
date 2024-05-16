package com.example.teamproject_11

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.teamproject_11.databinding.ActivityDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }



    private fun initView(){
        val toolBar = binding.detailToolBar
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val listDao = MyListDataBase.getMyListDataBase(this).getMyListDAO()
        binding.detailBtnPlay.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                dummyData.forEach {
                    val id = it.id
                    val title = it.snippet?.title
                    val description = it.snippet?.description
                    val thumbnail = it.snippet?.thumbnails?.high?.url
                    val data = FavoriteData(id, title, description, thumbnail)
                    listDao.insertData(data)
                }
            }
        }
        binding.detailPoster.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val list = listDao.getMyListData()
                Log.d("룸 확인", list.toString())
            }
        }
    }
}