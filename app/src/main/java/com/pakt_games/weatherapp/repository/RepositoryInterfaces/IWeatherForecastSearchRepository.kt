package com.pakt_games.weatherapp.repository.RepositoryInterfaces

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.ui.model.SavedCities

interface IWeatherForecastSearchRepository {

    suspend fun getCityName(cityName:String): kotlinx.coroutines.flow.Flow<WeatherForecastResponse?>

    suspend fun insertCityAsync(savedCities: SavedCities)

    suspend fun deleteTable()
}