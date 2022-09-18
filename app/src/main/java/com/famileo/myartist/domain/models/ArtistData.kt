package com.famileo.myartist.domain.models

import com.famileo.myartist.core.util.getFlag
import com.famileo.myartist.presentation.models.UiArtist

/**
 * Artist data domain object.
 * */
data class ArtistData(
    val id: String,
    val name: String,
    val country: String = "",
    val gender: String = "",
    val score: Int = 0,
    val type: String = "",
)

fun ArtistData.toUiArtist(): UiArtist {
    return (UiArtist(id = id, name = "${name.getFlag(country)} $name", gender = gender, score = score.div(10)))
}