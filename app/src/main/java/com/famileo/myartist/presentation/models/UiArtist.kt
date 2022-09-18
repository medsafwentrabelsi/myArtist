package com.famileo.myartist.presentation.models

data class UiArtist(
    val id: String,
    val name: String,
    val gender: String = "",
    val score: Int = 0,
)

