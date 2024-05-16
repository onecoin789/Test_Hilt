package com.example.teamproject_11.data


import com.example.teamproject_11.YouTubeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApiService {
    @GET("videos")
    fun getVideoInfo(
        @Query("key") apiKey: String = RetroClient.API_KEY,
        @Query("part") part: String = "snippet",
        @Query("chart") order: String = "mostPopular",
        @Query("type") type: String = "video",
        @Query("maxResult") maxResult: Int,
        @Query("videoCategoryId") categoryId: String? = null,
        @Query("regionCode") regionCode: String = "KR"
    ): Call<YouTubeResponse>
}