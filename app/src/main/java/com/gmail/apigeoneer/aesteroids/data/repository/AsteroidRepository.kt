package com.gmail.apigeoneer.aesteroids.data.repository

import android.net.Network
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.gmail.apigeoneer.aesteroids.data.AsteroidsDatabase
import com.gmail.apigeoneer.aesteroids.data.domain.Asteroid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate

class AsteroidRepository(private val database: AsteroidsDatabase) {

    @RequiresApi(Build.VERSION_CODES.O)
    private val startDate = LocalDate.now()

    @RequiresApi(Build.VERSION_CODES.O)
    private val endDate = startDate.plusDays(7)

    // Convert your LiveData list of DatabaseVideo objects to domain Video objects
    @RequiresApi(Build.VERSION_CODES.O)
    val asteroids: LiveData<List<Asteroid>> = Transformations
        .map(database.asteroidDao.getAsteroids(
            startDate.toString(), endDate.toString())) {
            it.toDomainModel()
        }

    suspend fun refreshAsteroids() {
        /**
         * Make a network call to getAsteroids(), & use the await() function
         * to tell the coroutine to suspend until the data is available.
         * Then call insertAll() to insert the asteroids into the database.
         * * -> spread operator: allows you to pass in an array to a fun that expects varargs.
         */
        val startDateFormatted = "2021-06-05"
        val endDateFormatted = "2021-06-12"
        withContext(Dispatchers.IO) {
            val asteroidsList = Network.(
                startDateFormatted, endDateFormatted).await()
            database.asteroidDao.insertAll(*asteroidsList.toDatabaseModel())
        }
    }

}