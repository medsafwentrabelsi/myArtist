package com.famileo.myartist.domain.models

import com.famileo.myartist.presentation.models.UiDiscography

/**
 * Artist Discography data domain object.
 * */
data class ArtistDiscographyData(
    val firstReleaseDate: String,
    val id: String,
    val title: String
)

fun ArtistDiscographyData.toUiDiscography(): UiDiscography {
    return (UiDiscography(firstReleaseDate = firstReleaseDate, title = title))
}