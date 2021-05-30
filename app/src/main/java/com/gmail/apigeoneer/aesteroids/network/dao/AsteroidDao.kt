package com.gmail.apigeoneer.aesteroids.network.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gmail.apigeoneer.aesteroids.network.entities.AsteroidEntity

@Dao
interface AsteroidDao {
    @Query("select * from asteroid_table order by date(closeApproachDate) asc")
    fun getAsteroids(): LiveData<List<AsteroidEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg asteroids: AsteroidEntity)
}