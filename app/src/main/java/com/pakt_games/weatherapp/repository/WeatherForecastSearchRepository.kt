package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.db.WeatherForecastDAO
import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastSearchRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.utils.API_KEY
import kotlinx.coroutines.flow.flow

class WeatherForecastSearchRepository(private val api: WeatherForecastAPI, private val weatherForecastDAO: WeatherForecastDAO): IWeatherForecastSearchRepository {
    override suspend fun getCityName(cityName:String)= flow {
        val currentCityResponse = api.getCity(API_KEY,cityName)
        emit(currentCityResponse)
    }
    override suspend fun insertCityAsync(savedCities: SavedCities) = weatherForecastDAO.insertCity(savedCities)

    override suspend fun deleteTable()=weatherForecastDAO.delete()
}