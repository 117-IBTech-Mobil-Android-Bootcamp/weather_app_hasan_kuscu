package com.pakt_games.weatherapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pakt_games.weatherapp.ui.model.CityCurrent
import com.pakt_games.weatherapp.ui.model.SavedCities

@Dao
interface WeatherForecastDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(savedCity : SavedCities)

    @Update
    suspend fun updateSavedCity(savedCity: SavedCities)

    @Query("SELECT * FROM SAVEDCITIES ")
    suspend fun  fetchCities() : List<SavedCities>
}