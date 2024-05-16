package com.example.teamproject_11

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface MyListDAO {
    @Insert
    fun insertData(data: FavoriteData)
    @Query("SELECT * FROM MYLIST")
    fun getMyListData() : List<FavoriteData>
}

