package com.gmail.apigeoneer.aesteroids.network

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gmail.apigeoneer.aesteroids.network.dao.AsteroidDao
import com.gmail.apigeoneer.aesteroids.network.dao.PictureOfTheDayDao

/**
 * The Room Database class puts together the Entity & the Dao
 */
@Database(entities = [MyDatabase::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract val asteroidDao: AsteroidDao
    abstract val pictureOfTheDayDao: PictureOfTheDayDao
}


/**
 * Use the singleton pattern to get an instance of the database
 */

// var for our singleton
private lateinit var INSTANCE: MyDatabase

fun getDatabase(context: Context): MyDatabase {
    // Made code synchronized so its thread safe
    synchronized(MyDatabase::class.java) {
        // Check whether the database has been initialized
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
            MyDatabase::class.java,
            "asteroids").build()
        }
    }
    return INSTANCE
}