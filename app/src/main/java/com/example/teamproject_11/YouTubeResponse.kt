package com.example.teamproject_11

import com.google.gson.annotations.SerializedName
import java.util.Date

//유튜브 API 데이터 전송 형태
data class YouTubeResponse (
    @SerializedName("kind") val kind : String?,
    @SerializedName("etag") val etag : String?,
    @SerializedName("nextPageToken") val nextPageToken : String?,
    @SerializedName("prevPageToken") val prevPageToken : String?,
    @SerializedName("pageInfo") val pageInfo : Page?,
    @SerializedName("items") val items : List<YouTubeVideo>?,
)

//유튜브 전송 데이터 속성 중 PageInfo 오브젝트 클래스
data class Page(
    val totalResults: Int?,
    val resultsPerPage: Int,
)

//유튜브 전송 데이터 솓성 중 items에 해당하는 오브젝트 클래스
data class YouTubeVideo(
    val kind: String?,
    val etag: String?,
    val id: String?,
    val snippet: Snippet?
)

//items의 속성 중 snippet에 해당하는 오브젝트 클래스, snippet은 해당 item의 업로드 시간 및 제목, 영상 설명 등의 속성을 가지고 있음
data class Snippet(
    val publishedAt: Date?,
    val channelId : String?,
    val title : String?,
    val description : String?,
    val thumbnails : Thumbnails?,
    val tags: List<String?>?,
    val categoryId: String?,
    )

//snippet의 속성 중 썸네일에 해당하는 오브젝트 클래스, 해당 클래스는 Key라는 오브젝트 속성을 가지고 Key에 이미지 url 및 너비 길이 정보가 있음
data class Thumbnails(
    val key : Key?
)

data class Key(
    val url : String?,
    val width: Int?,
    val height: Int?,
)

