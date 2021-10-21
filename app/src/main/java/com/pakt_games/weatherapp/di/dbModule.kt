package com.pakt_games.weatherapp.di

import androidx.room.Room
import com.pakt_games.weatherapp.db.WeatherForecastDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATABASE_NAME = "CITIESDB"
val dbModule = module {

    // Room Database
    single { Room.databaseBuilder(androidContext(), WeatherForecastDatabase::class.java, DATABASE_NAME).build() }

    // CitiesDao
    single { get<WeatherForecastDatabase>().weatherForecastDao() }
}