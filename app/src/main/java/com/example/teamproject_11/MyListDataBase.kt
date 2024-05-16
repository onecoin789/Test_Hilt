package com.example.teamproject_11

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FavoriteData::class], exportSchema = false, version = 1)
abstract class MyListDataBase : RoomDatabase() {
    abstract fun getMyListDAO() : MyListDAO

    companion object {
        private var INSTANCE: MyListDataBase? = null


        fun getMyListDataBase(context: Context): MyListDataBase {
            if(INSTANCE == null) {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context, MyListDataBase::class.java, "MyList"
                    ).build()
                    INSTANCE = instance
                }
            }
            return INSTANCE!!
        }
    }
}