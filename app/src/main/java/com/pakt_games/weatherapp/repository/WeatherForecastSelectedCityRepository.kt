package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.db.WeatherForecastDAO
import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.utils.API_KEY
import com.pakt_games.weatherapp.utils.Result

class WeatherForecastSelectedCityRepository(private val api: WeatherForecastAPI, private val weatherForecastDAO: WeatherForecastDAO) {

    suspend fun getCityPropertiesForUpdateDatabase(cityName:String): Result<WeatherForecastResponse> {
        val currentCityResponse = api.getCity(API_KEY, cityName)
        return if (currentCityResponse != null) {
            Result.Success(currentCityResponse)
        }
        else Result.Error(
            "Bir hata meydana geldi"
        )
    }
    suspend fun getAllSavedCitiesData(): List<SavedCities> {
        val readAllSavedCities: List<SavedCities> =weatherForecastDAO.fetchCities()
        return readAllSavedCities
    }
    suspend fun updateCity(savedCity: SavedCities) = weatherForecastDAO.updateSavedCity(savedCity)

}