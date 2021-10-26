package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastDetailRepository
import com.pakt_games.weatherapp.utils.API_KEY
import kotlinx.coroutines.flow.flow

class WeatherForecastDetailRepository(private val api: WeatherForecastAPI):
/*
    Getting Data In API
    I using the flow in the repository layer.
*/
    IWeatherForecastDetailRepository {
    override suspend fun getCityDailyPropertiesFromRemote(cityName:String)= flow {
        val currentCityResponse = api.getCity(API_KEY,cityName)
        emit(currentCityResponse)
    }
}