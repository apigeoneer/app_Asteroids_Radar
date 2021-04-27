package com.gmail.apigeoneer.aesteroids.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nasa.gov/"

// Create a Retrofit obj
private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

interface AsteroidApiService {
    // @GET -> specifying the endpoint for the JSON Asteroid response
    @GET("realstate")
    fun getProperties():           // Request the JSON response string
            Call<String>          // starts the HTTP request
}

/**
 * Expose the Retrofit service to the rest of the app through a public object
 */
object AsteroidApi {
    val retrofitService: AsteroidApiService by lazy {
        retrofit.create(AsteroidApiService::class.java)
    }
}
