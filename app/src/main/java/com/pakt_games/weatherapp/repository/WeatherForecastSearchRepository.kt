package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.db.WeatherForecastDAO
import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastSearchRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.utils.API_KEY
import kotlinx.coroutines.flow.flow

class WeatherForecastSearchRepository(private val api: WeatherForecastAPI, private val weatherForecastDAO: WeatherForecastDAO): IWeatherForecastSearchRepository {
    /*
        Getting Data In API
        I using the flow in the repository layer.
    */
    override suspend fun getCityName(cityName:String)= flow {
        val currentCityResponse = api.getCity(API_KEY,cityName)
        emit(currentCityResponse)
    }
    /*
    Inserting city in the DATABASE
    */
    override suspend fun insertCityAsync(savedCities: SavedCities) = weatherForecastDAO.insertCity(savedCities)
}