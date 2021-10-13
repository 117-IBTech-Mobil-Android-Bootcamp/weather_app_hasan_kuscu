package com.pakt_games.weatherapp.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pakt_games.weatherapp.ui.model.CityCurrent

interface WeatherForecastDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie : CityCurrent)

    @Query("SELECT * FROM CITYCURRENT")
    suspend fun  fetchMovies() : List<CityCurrent>
}