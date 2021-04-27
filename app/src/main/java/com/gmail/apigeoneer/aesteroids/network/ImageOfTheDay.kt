package com.gmail.apigeoneer.aesteroids.network

import com.squareup.moshi.Json

data class ImageOfTheDay(
    val url:String,
    @Json(name="media_type") val mediaType: String,
    val title: String
)