package com.gmail.apigeoneer.aesteroids.api

import com.gmail.apigeoneer.aesteroids.Constants.BASE_URL
import com.gmail.apigeoneer.aesteroids.data.Asteroid
import com.gmail.apigeoneer.aesteroids.data.AsteroidData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val URL = BASE_URL                           // make sure the base url is the base url. don't play w/ it & start appending all kinds of stupid things
const val API_KEY = "9U2n06m8hLP7vkIucT8MUW7bcQVtzukDdAvYyOnl"

interface AsteroidApiService {
    // https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY

    // @GET -> specifying the endpoint for the JSON Asteroid response
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(@Query("start_date") startDate: String,
            @Query("end_date") endDate: String,
            @Query("api_key") apiKey: String
    ): String

}

//  Create a Moshi object
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit obj for the Asteroid data
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())                     // for the Asteroids
    .addConverterFactory(MoshiConverterFactory.create(moshi))                  // for the ImageOfDay
    // .addCallAdapterFactory(CoroutineCallAdapterFactory())                   // for Coroutines                   // depreciated
    .baseUrl(BASE_URL)
    .build()

/**
 * Expose the Retrofit service to the rest of the app through a public object (Singleton)
 * we make a singleton since we don't want to create an instance of the api many times
 * we'll just create 1 instance (ie. here) & use it everywhere
 */
object AsteroidApi {
    val retrofitService: AsteroidApiService by lazy {
        retrofit.create(AsteroidApiService::class.java)
    }
}
