package com.gmail.apigeoneer.aesteroids.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.gmail.apigeoneer.aesteroids.api.API_KEY
import com.gmail.apigeoneer.aesteroids.api.AsteroidApi
import com.gmail.apigeoneer.aesteroids.data.AsteroidData
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel(application: Application): AndroidViewModel(application) {

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
//         _response.value = "Set the Mars API response here!"

//        val asteroid = AsteroidApi.retrofitService.getAsteroids("2019-9-7", "2019-9-8")
//        asteroid.enqueue(object : Callback<AsteroidData> {
//
//            override fun onFailure(call: Call<AsteroidData>, t: Throwable) {
//                Log.d(TAG, "Failed to fetch asteroids from the network: ${t.message}")
//            }
//
//            override fun onResponse(call: Call<AsteroidData>, response: Response<AsteroidData>) {
//                val asteroidResponse= response.body()
//                Log.d(TAG, "${asteroidResponse?.elementCount.toString()} asteroids retrieved")
//            }
//        })

        viewModelScope.launch {
            try {
                val listResult = AsteroidApi.retrofitService.getAsteroids("2021-5-5", "2021-5-6", API_KEY)
                _response.value = "Success: ${listResult.length} Asteroids retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
            Log.d(TAG, _response.toString())
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return OverviewViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}