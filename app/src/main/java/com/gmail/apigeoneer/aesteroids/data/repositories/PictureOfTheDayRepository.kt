package com.gmail.apigeoneer.aesteroids.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.gmail.apigeoneer.aesteroids.data.AsteroidsDatabase
import com.gmail.apigeoneer.aesteroids.data.domain.PictureOfTheDay
import com.gmail.apigeoneer.aesteroids.data.toDatabaseModel
import com.gmail.apigeoneer.aesteroids.data.toDomainModel
import com.gmail.apigeoneer.aesteroids.network.API_KEY
import com.gmail.apigeoneer.aesteroids.network.AsteroidApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PictureOfTheDayRepository(private val database: AsteroidsDatabase) {

    companion object {
        private const val TAG="PictureOfTheDayRepository"
    }

    val pictureOfTheDay: LiveData<PictureOfTheDay> =
        Transformations.map(database.pictureOfTheDayDao.getPictureOfTheDay()) {
            it?.toDomainModel()
        }

    suspend fun refreshPictureOfTheDay() {
        withContext(Dispatchers.IO) {
            try {
                val picture = AsteroidApi.pictureOdTheDayService.getPictureOfTheDayAsync(API_KEY).await()
                database.pictureOfTheDayDao.insertAll(picture.toDatabaseModel())
//                if (picture.mediaType == "image") {
//
//                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d(TAG, "PictureOfTheDay retrieval unsuccessful: ${e.message}")
                }
            }
        }
    }

}