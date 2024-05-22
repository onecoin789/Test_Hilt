package com.example.teamproject_11.data.di

import android.app.Application
import androidx.room.Room
import com.example.teamproject_11.room.MyListDAO
import com.example.teamproject_11.room.MyListDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideVideoData(application: Application) : MyListDataBase {
        return Room.databaseBuilder(
            application,
            MyListDataBase::class.java,
            "MyListDataBase"
        )
            .build()
    }

    @Provides
    fun ProvidesDao(appData: MyListDataBase) : MyListDAO {
        return appData.getMyListDAO()
    }
}