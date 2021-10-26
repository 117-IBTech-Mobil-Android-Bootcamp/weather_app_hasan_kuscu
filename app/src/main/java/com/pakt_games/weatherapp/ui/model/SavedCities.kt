package com.pakt_games.weatherapp.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SAVEDCITIES")
data class SavedCities(
    @PrimaryKey @ColumnInfo(name = "id") val id : Int?,
    @ColumnInfo(name = "cityName") var cityName : String,
    @ColumnInfo(name = "temp_c") val temp_c : String,
    @ColumnInfo(name = "temp_f") val temp_f : String,
    @ColumnInfo(name = "feelslike_c") val feelslike_c : String,
    @ColumnInfo(name = "feelslike_f") val feelslike_f : String,
    @ColumnInfo(name = "cityAirStatuText") val cityAirStatuText : String,
    @ColumnInfo(name = "cityAirStatuIcon") val cityAirStatuIcon : String,
)
