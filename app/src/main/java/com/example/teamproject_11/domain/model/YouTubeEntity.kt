package com.example.teamproject_11.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


//data class YouTubeResponse(
//    val kind: String?,
//    val etag: String?,
//    val nextPageToken: String?,
//    val prevPageToken: String?,
//    val pageInfo: PageEntity?,
//    val items: List<YouTubeVideo>?,
//)
//
//data class PageEntity(
//    val totalResults: Int?,
//    val resultsPerPage: Int,
//)
//
//data class YouTubeVideo(
//    val kind: String?,
//    val etag: String?,
//    val id: String,
//    val snippet: Snippet?
//)
//
//data class Snippet(
//    val publishedAt: String?, //임시로 Date 타입에서 String으로 바꿨습니다
//    val channelId: String?,
//    val title: String?,
//    val description: String?,
//    val thumbnails: Thumbnails?,
//    val tags: List<String?>?,
//    val categoryId: String?,
//)
//
//data class Thumbnails(
//    val default: Key,
//    val medium: Key,
//    val high: Key,
//)
//
//data class Key(
//    val url: String?,
//    val width: Int?,
//    val height: Int?,
//)

@Entity(tableName = "search_videos")
data class SearchVideo(
    @PrimaryKey
    val id: String,
    val imgThumbnail: String?,
    val title: String?,
    val dateTime: String?,
    val description: String?,
    val type: Int
)