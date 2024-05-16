package com.example.teamproject_11

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teamproject_11.home.data.HomeVideoModel


//디테일 액티비티에서 쓸 뷰모델
class DetailViewModel: ViewModel() {

    private val _data : MutableLiveData<HomeVideoModel> = MutableLiveData()
    val data : LiveData<HomeVideoModel> get() = _data

    fun getClickData(data: HomeVideoModel){
        _data.postValue(data)
    }


}