package com.pakt_games.weatherapp.ui.model

import android.hardware.SensorManager
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CITYCURRENT")
data class CityCurrent(
    @PrimaryKey @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "temp_c") val temp_c : Double,
    @ColumnInfo(name = "temp_f") val temp_f : Double,
    @ColumnInfo(name = "fellslike_c") val feelslike_c : Double,
    @ColumnInfo(name = "fellslike_f") val feelslike_f : Double,
    @ColumnInfo(name = "condution") val condution : CityCondution
)
