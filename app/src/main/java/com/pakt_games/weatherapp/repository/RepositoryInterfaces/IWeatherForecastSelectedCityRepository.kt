package com.pakt_games.weatherapp.repository.RepositoryInterfaces

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.ui.model.SavedCities

interface IWeatherForecastSelectedCityRepository {

    suspend fun getCity(cityName:String): kotlinx.coroutines.flow.Flow<WeatherForecastResponse?>

    suspend fun getAllSavedCitiesData(): List<SavedCities>

    suspend fun updateCity(id:Int,cityName: String, temp_c: String, temp_f: String, feelslike_c: String, feelslike_f: String, cityAirStatuText: String,
                           cityAirStatuIcon: String)
}