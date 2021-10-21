package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.db.WeatherForecastDAO
import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.utils.API_KEY
import com.pakt_games.weatherapp.utils.Result

class WeatherForecastSearchRepository(private val api: WeatherForecastAPI, private val weatherForecastDAO: WeatherForecastDAO) {

    suspend fun getCityName(cityName:String): Result<WeatherForecastResponse> {
        val currentCityResponse = api.getCity(API_KEY, cityName)
        return if (currentCityResponse != null) {
            Result.Success(currentCityResponse)
        }
        else Result.Error(
            "bir hata meydana geldi"
        )
    }
    suspend fun insertDataAsync(savedCities: SavedCities) = weatherForecastDAO.insertCity(savedCities)

}