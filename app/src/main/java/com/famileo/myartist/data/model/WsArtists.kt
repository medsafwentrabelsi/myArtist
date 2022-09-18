package com.famileo.myartist.data.model

import com.famileo.myartist.domain.models.ArtistData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WsArtists(
    @SerialName("artists")
    val artists: List<WsArtist>,
    @SerialName("count")
    val count: Int,
    @SerialName("created")
    val created: String,
    @SerialName("offset")
    val offset: Int
)

@Serializable
data class WsArtist(
    @SerialName("country")
    val country: String = "",
    @SerialName("gender")
    val gender: String = "",
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("score")
    val score: Int = 0,
    @SerialName("type")
    val type: String = "",
)

fun WsArtist.toArtistData(): ArtistData {
    return ArtistData(id = id, name = name, country = country, gender = gender, score = score, type = type)
}