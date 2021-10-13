package com.pakt_games.weatherapp.di

import com.pakt_games.weatherapp.repository.WeatherForecastDetailRepository
import org.koin.dsl.module

val weatherForecastDetailRepositoryModule = module {
    factory { WeatherForecastDetailRepository(get()) }
}