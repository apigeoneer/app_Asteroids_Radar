package com.gmail.apigeoneer.aesteroids.network

import androidx.room.PrimaryKey
import com.gmail.apigeoneer.aesteroids.database.DatabaseAsteroid

data class NetworkAsteroidContainer(val asteroids: List<NetworkAsteroid>)

data class NetworkAsteroid constructor(
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

fun NetworkAsteroidContainer.asDatabaseModel(): Array<DatabaseAsteroid> {
    return asteroids.map {
        DatabaseAsteroid (
                id = it.id,
                codeName = it.codeName,
                closeApproachDate = it.closeApproachDate,
                absMagnitude = it.absMagnitude,
                estDiaMax = it.estDiaMax,
                isHazardous = it.isHazardous,
                relativeVelocity = it.relativeVelocity,
                distanceFromEarth = it.distanceFromEarth
        )
    }.toTypedArray()
}