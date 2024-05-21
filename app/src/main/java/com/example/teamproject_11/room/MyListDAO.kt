package com.example.teamproject_11.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import com.example.teamproject_11.presentation.home.model.HomeVideoModel

@Dao
interface MyListDAO {
    @Insert
    fun insertData(data: HomeVideoModel)
    @Query("SELECT * FROM MYLIST")
    fun getMyListData() : List<HomeVideoModel>
    @Delete
    fun deleteData(data: HomeVideoModel)
}

