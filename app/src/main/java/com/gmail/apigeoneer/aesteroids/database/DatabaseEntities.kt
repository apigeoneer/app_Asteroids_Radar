package com.gmail.apigeoneer.aesteroids.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gmail.apigeoneer.aesteroids.data.Asteroid

@Entity
data class DatabaseAsteroid constructor(
        @PrimaryKey
        val id: Long,
        val codeName: String,
        val closeApproachDate: String,
        val absMagnitude: Double,
        val estDiaMax: Double,
        val isHazardous: Boolean,
        val relativeVelocity: Double,
        val distanceFromEarth: Double,
)

fun List<DatabaseAsteroid>.asDomainModel(): List<Asteroid> {
    return map {
        Asteroid(
                id = it.id,
                codeName = it.codeName,
                closeApproachDate = it.closeApproachDate,
                absMagnitude = it.absMagnitude,
                estDiaMax = it.estDiaMax,
                isHazardous = it.isHazardous,
                relativeVelocity = it.relativeVelocity,
                distanceFromEarth = it.distanceFromEarth
        )
    }
}