package com.gmail.apigeoneer.aesteroids.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nasa.gov/"
private const val API_KEY = "9U2n06m8hLP7vkIucT8MUW7bcQVtzukDdAvYyOnl"
private const val START_DATE = "2015-09-07"
private const val END_DATE = "2015-09-08"

//  Create a Moshi object
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Create a Retrofit obj
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface AsteroidApiService {
    // @GET -> specifying the endpoint for the JSON Asteroid response
    @GET("neo/rest/v1/feed?start_date=$START_DATE&end_date=$END_DATE&api_key=$API_KEY")  // Neo-FEED
    fun getAsteroids():                  // Request the JSON response string
            Call<List<Asteroid>>          // starts the HTTP request
}

/**
 * Expose the Retrofit service to the rest of the app through a public object
 */
object AsteroidApi {
    val retrofitService: AsteroidApiService by lazy {
        retrofit.create(AsteroidApiService::class.java)
    }
}
