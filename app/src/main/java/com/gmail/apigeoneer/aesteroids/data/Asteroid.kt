package com.gmail.apigeoneer.aesteroids.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Parcelable is a serialization mechanism provided by Android to pass complex data from one activity to another activity.
 * In order to write an object to a Parcel, that object should implement the interface “Parcelable“.
 */
@Parcelize
data class Asteroid(
    val id: Long,
    val codename: String,
    val closeApproachDate: String,
    val absoluteMagnitude: Double,
    val estimatedDiameter: Double,
    val relativeVelocity: Double,
    val distanceFromEarth: Double,
    val isPotentiallyHazardous: Boolean
): Parcelable