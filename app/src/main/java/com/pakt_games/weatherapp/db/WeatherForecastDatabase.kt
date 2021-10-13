package com.pakt_games.weatherapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pakt_games.weatherapp.ui.model.CityCurrent

@Database(entities = [CityCurrent::class], version = 1)
abstract class WeatherForecastDatabase : RoomDatabase() {
    abstract fun moviesDao() : WeatherForecastDAO
}