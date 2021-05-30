package com.gmail.apigeoneer.aesteroids.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gmail.apigeoneer.aesteroids.database.DatabaseAsteroid

@Entity(tableName = "asteroid_table")
data class NetworkAsteroid constructor(
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
