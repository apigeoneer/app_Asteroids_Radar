package com.gmail.apigeoneer.aesteroids.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gmail.apigeoneer.aesteroids.database.DatabaseAsteroid
import com.squareup.moshi.Json

@Entity(tableName = "asteroid_table")
data class AsteroidEntity constructor(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val codeName: String,
        val closeApproachDate: String,
        val absMagnitude: Double,
        val estDiaMax: Double,
        val isHazardous: Boolean,
        val relativeVelocity: Double,
        val distanceFromEarth: Double,
)

@Entity(tableName = "picture_of_the_day_table")
data class PictureOfTheDayEntity(
        @PrimaryKey(autoGenerate = true)
        val url: String,
        val mediaType: String,
        val title: String
)
