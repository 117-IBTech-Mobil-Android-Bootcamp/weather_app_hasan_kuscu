package com.pakt_games.weatherapp.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SAVEDCITIES")
data class SavedCities(
        @PrimaryKey @ColumnInfo(name = "id") val id : Int,
        @ColumnInfo(name = "cityName") val cityName : String,
        @ColumnInfo(name = "temp_c") val temp_c : Double,
        @ColumnInfo(name = "temp_f") val temp_f : Double,
        @ColumnInfo(name = "feelslike_c") val feelslike_c : Double,
        @ColumnInfo(name = "feelslike_f") val feelslike_f : Double,
        @ColumnInfo(name = "cityAirStatuText") val cityAirStatuText : String,
        @ColumnInfo(name = "cityAirStatuIcon") val cityAitStatuIcon : String,
)
