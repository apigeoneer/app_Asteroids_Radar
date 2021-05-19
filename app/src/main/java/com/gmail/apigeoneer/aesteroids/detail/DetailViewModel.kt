package com.gmail.apigeoneer.aesteroids.detail

import android.app.Application
import androidx.lifecycle.*
import com.gmail.apigeoneer.aesteroids.data.Asteroid
import com.gmail.apigeoneer.aesteroids.overview.OverviewViewModel

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