package com.gmail.apigeoneer.aesteroids.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.apigeoneer.aesteroids.data.Asteroid
import com.gmail.apigeoneer.aesteroids.api.AsteroidApi
import com.gmail.apigeoneer.aesteroids.data.AsteroidData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel: ViewModel() {

    companion object {
        private const val TAG = "OverviewViewModel"
    }

    // the internal MutableLiveData String that stores the status of the most recent requests
    // response -> the request status String
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    // Call getMarsRealEstateProperties() on init so we can display status immediately
    init {
        getAsteroids()
    }

    /**
     * Sets the value of the status LiveData to the NASA Asteroid API status
     */
    private fun getAsteroids() {
        // _response.value = "Set the Mars API response here!"

        val asteroid = AsteroidApi.retrofitService.getAsteroids("2015-9-7", "2015-9-8")
        asteroid.enqueue(object : Callback<AsteroidData> {

            override fun onFailure(call: Call<AsteroidData>, t: Throwable) {
                Log.d(TAG, "Failed to fetch asteroids from the network: ${t.message}")
            }

            override fun onResponse(call: Call<AsteroidData>, response: Response<AsteroidData>) {
                val asteroidResponse= response.body()
                Log.d(TAG, "$asteroidResponse?.elementCount.toString() asteroids retrieved")
            }
        })
    }
}