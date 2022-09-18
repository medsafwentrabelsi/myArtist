package com.famileo.myartist.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Artist database object.
 */
@Entity(tableName = "artist", primaryKeys = ["id"])
data class ArtistEntity(
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "score")
    val score: Int,
    @ColumnInfo(name = "type")
    val type: String,
)