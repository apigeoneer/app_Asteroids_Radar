package com.gmail.apigeoneer.aesteroids.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gmail.apigeoneer.aesteroids.data.Asteroid

class DetailViewModel(
        asteroid: Asteroid,
        app: Application
): AndroidViewModel(app) {

    // the asteroid item user clicks on in the overview screen
    private val _selectedAsteroid = MutableLiveData<Asteroid>()
    val selectedAsteroid: LiveData<Asteroid>
        get() = _selectedAsteroid

    // for navigating to the detail screen
    private val _navigateToSelectedAsteroid = MutableLiveData<Asteroid>()
    val navigateToSelectedAsteroid: LiveData<Asteroid>
        get() = _navigateToSelectedAsteroid

    init {
        _selectedAsteroid.value = asteroid
    }

    // initiate navigation to the detail screen
    fun displayAsteroidDetails(asteroid: Asteroid) {
        _navigateToSelectedAsteroid.value = asteroid
    }

    fun displayAsteroidDetailsComplete() {
        _navigateToSelectedAsteroid.value = null
    }

}