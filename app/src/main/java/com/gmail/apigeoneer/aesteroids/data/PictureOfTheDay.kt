package com.gmail.apigeoneer.aesteroids.data

import com.squareup.moshi.Json

data class PictureOfTheDay (
    val url: String,
    @Json(name = "mediaType") val media_type: String,
    val title: String
)