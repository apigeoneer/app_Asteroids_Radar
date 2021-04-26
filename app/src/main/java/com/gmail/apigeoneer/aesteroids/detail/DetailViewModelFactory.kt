package com.gmail.apigeoneer.aesteroids.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.apigeoneer.aesteroids.network.Asteroid
import java.lang.IllegalArgumentException

/**
 * We need a ViewModelFactory to provide the Asteroid & context to the ViewModel
 */
class DetailViewModelFactory(
        private val asteroid: Asteroid,
        private val application: Application
): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(asteroid, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}