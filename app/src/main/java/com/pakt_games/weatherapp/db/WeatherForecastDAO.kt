package com.pakt_games.weatherapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pakt_games.weatherapp.ui.model.CityCurrent
import com.pakt_games.weatherapp.ui.model.SavedCities

@Dao
interface WeatherForecastDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(savedCity : SavedCities)

    @Query("SELECT * FROM SAVEDCITIES ")
    suspend fun  fetchCities() : List<SavedCities>
}