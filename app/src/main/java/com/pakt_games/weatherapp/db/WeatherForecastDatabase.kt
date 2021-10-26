package com.pakt_games.weatherapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pakt_games.weatherapp.ui.model.CityCurrent
import com.pakt_games.weatherapp.ui.model.SavedCities
/*
    SavedCities is my entitiy class
*/
@Database(entities = [SavedCities::class], version = 1)
abstract class WeatherForecastDatabase : RoomDatabase() {

    abstract fun weatherForecastDao() : WeatherForecastDAO

}