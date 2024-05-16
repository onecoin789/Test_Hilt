package com.example.teamproject_11.home.data

import com.example.teamproject_11.YouTubeVideo


data class HomeVideoResponse(
    val items: List<YouTubeVideo>
)

data class HomeVideoModel(
    val imgThumbnail: String?,
    val title: String?,
    val dateTime: String?,
    val description: String?,
)

