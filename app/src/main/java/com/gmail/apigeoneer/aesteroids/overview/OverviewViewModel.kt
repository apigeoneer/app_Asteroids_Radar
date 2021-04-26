package com.gmail.apigeoneer.aesteroids.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OverviewViewModel: ViewModel() {

    // the internal MutableLiveData String that stores the status of the most recent requests
    // response -> the request status String
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    // Call getMarsRealEstateProperties() on init so we can display status immediately
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the NASA Asteroid API status
     */
    private fun getMarsRealEstateProperties() {
        _response.value = "Set the Mars API response here!"
    }
}