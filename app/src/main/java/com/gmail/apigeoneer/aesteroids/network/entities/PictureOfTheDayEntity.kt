package com.gmail.apigeoneer.aesteroids.network.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "picture_of_the_day_table")
@Parcelize
data class PictureOfTheDayEntity(
        @PrimaryKey(autoGenerate = true)
        val url: String,
        val mediaType: String,
        val title: String
) : Parcelable
