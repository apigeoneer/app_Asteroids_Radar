package com.gmail.apigeoneer.aesteroids.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AsteroidDao {
    @Query("select * from asteroid_table order by date(closeApproachDate) asc")
    fun getAsteroids(): LiveData<List<AsteroidEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg asteroids: AsteroidEntity)
}

@Dao
interface PictureOfTheDayDao {
    @Query("select * from picture_of_the_day_table")
    fun getPictureOfTheDay(): LiveData<PictureOfTheDayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg asteroids: PictureOfTheDayEntity)
}

//@Database(entities = [AsteroidsDatabase::class], version = 1)
//abstract class AsteroidsDatabase: RoomDatabase() {
//    abstract val asteroidDao: AsteroidDao
//}
//
//// var for our singleton
//private lateinit var INSTANCE: AsteroidsDatabase
//
//fun getDatabase(context: Context): AsteroidsDatabase {
//    // Made code synchronized so its thread safe
//    synchronized(AsteroidsDatabase::class.java) {
//        // Check whether the database has been initialized
//        if (!::INSTANCE.isInitialized) {
//            INSTANCE = Room.databaseBuilder(context.applicationContext,
//            AsteroidsDatabase::class.java,
//            "asteroids").build()
//        }
//    }
//    return INSTANCE
//}