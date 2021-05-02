package com.gmail.apigeoneer.aesteroids.data

import com.squareup.moshi.Json

data class AsteroidData (
        @Json(name="element_count") val elementCount: Int,
        @Json(name="near_earth_objects") val nearEarthObjects: List<Asteroid>
)