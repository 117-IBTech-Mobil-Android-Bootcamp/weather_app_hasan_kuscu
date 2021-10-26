package com.pakt_games.weatherapp.repository.RepositoryInterfaces

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

interface IWeatherForecastDetailRepository {
    suspend fun getCityDailyPropertiesFromRemote(cityName:String): kotlinx.coroutines.flow.Flow<WeatherForecastResponse?>
}