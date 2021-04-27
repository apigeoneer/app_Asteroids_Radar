package com.gmail.apigeoneer.aesteroids.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.apigeoneer.aesteroids.network.Asteroid
import com.gmail.apigeoneer.aesteroids.network.AsteroidApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel: ViewModel() {

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

        AsteroidApi.retrofitService.getAsteroids().enqueue(object : Callback<List<Asteroid>> {
            override fun onFailure(call: Call<List<Asteroid>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<List<Asteroid>>, response: Response<List<Asteroid>>) {
               // _response.value = response.body()
                _response.value = "Success: ${response.body()?.size} Asteroids retrieved"
            }
        })
    }
}