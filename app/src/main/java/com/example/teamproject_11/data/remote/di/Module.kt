package com.example.teamproject_11.data.remote.di

import com.example.teamproject_11.data.repository.VideoApiServiceImpl
import com.example.teamproject_11.domain.repository.YouTubeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface Module {
    @Binds
    fun bindsYoutubeRepository(videoApiServiceImpl: VideoApiServiceImpl) : YouTubeRepository
}