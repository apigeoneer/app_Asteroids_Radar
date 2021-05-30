package com.gmail.apigeoneer.aesteroids.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface AsteroidDao {
    @Query("select * from DatabaseAsteroid")
    fun getAsteroids(): LiveData<List<DatabaseAsteroid>>
}

