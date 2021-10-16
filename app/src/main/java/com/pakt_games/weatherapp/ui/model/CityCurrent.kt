package com.pakt_games.weatherapp.ui.model

import android.hardware.SensorManager
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CITYCURRENT")
data class CityCurrent(
     val id : Int,
     val temp_c : Double,
     val temp_f : Double,
     val feelslike_c : Double,
     val feelslike_f : Double,
     val condition: CityCondition

)
