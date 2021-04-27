package com.gmail.apigeoneer.aesteroids.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Parcelable is a serialization mechanism provided by Android to pass complex data from one activity to another activity.
 * In order to write an object to a Parcel, that object should implement the interface “Parcelable“.
 */

data class Asteroid(
    val id: Double,
    @Json(name = "absolute_magnitude") val absMagnitude: Double,
    @Json(name = "estimated_diameter_max") val estDiaMax: Double,
    @Json(name = "is_potentially_hazardous_asteroid") val isHazardous: Boolean,
    @Json(name = "kilometers_per_second") val kmps: Double,
    val astronomical: Double
)