package com.gmail.apigeoneer.aesteroids.network.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

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