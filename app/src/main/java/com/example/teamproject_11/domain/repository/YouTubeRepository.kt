package com.example.teamproject_11.domain.repository

import com.example.teamproject_11.data.model.YouTubeResponse
import com.example.teamproject_11.data.model.YouTubeSearchResponse
import com.example.teamproject_11.data.remote.di.RetrofitClient

interface YouTubeRepository {

    suspend fun getVideoInfo(
        apiKey: String = RetrofitClient.API_KEY,
        part: String = "snippet",
        order: String = "mostPopular",
        type: String = "video",
        maxResult: Int,
        categoryId: String? = null,
        regionCode: String = "KR",
        channelId: String? = null,
        pageToken: String?,
    ): YouTubeResponse

    suspend fun searchVideo(
        apiKey: String = RetrofitClient.API_KEY,
        part: String = "snippet",
        type: String = "video",
        maxResult: Int,
        regionCode: String = "KR",
        q: String?,
        pageToken: String?
    ): YouTubeSearchResponse
}