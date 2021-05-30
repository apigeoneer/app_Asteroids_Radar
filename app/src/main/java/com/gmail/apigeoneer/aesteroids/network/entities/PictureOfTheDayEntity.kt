package com.gmail.apigeoneer.aesteroids.network.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "picture_of_the_day_table")
data class PictureOfTheDayEntity(
        @PrimaryKey(autoGenerate = true)
        val url: String,
        val mediaType: String,
        val title: String
)
