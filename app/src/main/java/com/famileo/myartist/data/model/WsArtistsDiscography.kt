package com.famileo.myartist.data.model

import com.famileo.myartist.domain.models.ArtistDiscographyData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WsArtistsDiscography(
    @SerialName("release-groups")
    val wsDiscography: List<WsDiscography>,
)

@Serializable
data class WsDiscography(
    @SerialName("first-release-date")
    val firstReleaseDate: String,
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String
)

fun WsDiscography.toArtistDiscographyData(): ArtistDiscographyData {
    return ArtistDiscographyData(firstReleaseDate = firstReleaseDate, id = id, title = title)
}