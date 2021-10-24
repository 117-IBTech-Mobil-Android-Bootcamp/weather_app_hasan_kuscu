package com.pakt_games.weatherapp.di

import com.pakt_games.weatherapp.repository.WeatherForecastDetailRepository
import com.pakt_games.weatherapp.repository.WeatherForecastSearchRepository
import com.pakt_games.weatherapp.repository.WeatherForecastSelectedCityRepository
import org.koin.dsl.module

val weatherForecastDetailRepositoryModule = module {
    factory { WeatherForecastDetailRepository(get()) }
}
val weatherForecastSearchRepositoryModule = module {
    factory { WeatherForecastSearchRepository(get(),get()) }
}
val weatherForecastSelectedCityRepositoryModule = module {
    factory { WeatherForecastSelectedCityRepository(get(),get()) }
}