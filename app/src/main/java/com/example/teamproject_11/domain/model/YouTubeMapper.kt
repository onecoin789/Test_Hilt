package com.example.teamproject_11.domain.model

import com.example.teamproject_11.data.model.Key
import com.example.teamproject_11.data.model.Page
import com.example.teamproject_11.data.model.Snippet
import com.example.teamproject_11.data.model.Thumbnails
import com.example.teamproject_11.data.model.YouTubeResponse
import com.example.teamproject_11.data.model.YouTubeVideo
import com.example.teamproject_11.data.model.YouTubeVideoItem
import com.example.teamproject_11.presentation.main.DataType

fun YouTubeResponse.toEntity() = YouTubeResponse(
    kind = kind,
    etag = etag,
    nextPageToken = nextPageToken,
    prevPageToken = prevPageToken,
    pageInfo = pageInfo?.toEntity(),
    items = items?.map {
        it.toEntity()
    }
)

fun Page.toEntity() = Page(
    totalResults = totalResults,
    resultsPerPage = resultsPerPage
)

fun YouTubeVideo.toEntity() = YouTubeVideo(
    kind = kind,
    etag = etag,
    id = id,
    snippet = snippet?.toEntity()
)

fun Snippet.toEntity() = Snippet(
    publishedAt = publishedAt,
    channelId = channelId,
    title = title,
    description = description,
    thumbnails = thumbnails?.toEntity(),
    tags = tags,
    categoryId = categoryId,
)

fun Thumbnails.toEntity() = Thumbnails(
    default = default.toEntity(),
    medium = medium.toEntity(),
    high = high.toEntity()
)

fun Key.toEntity() = Key(
    url = url,
    width = width,
    height = height,
)

fun YouTubeVideoItem.toEntity(): SearchVideo {
    return SearchVideo(
        id = id?.videoId ?: "",
        imgThumbnail = snippet?.thumbnails?.high?.url,
        title = snippet?.title,
        dateTime = snippet?.publishedAt,
        description = snippet?.description,
        type = DataType.SEARCH_RESULT.viewType
    )
}

fun List<YouTubeVideoItem>.toEntityList(): List<SearchVideo> {
    return this.map { it.toEntity() }
}