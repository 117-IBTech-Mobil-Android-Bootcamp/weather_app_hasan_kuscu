package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.db.WeatherForecastDAO
import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastSelectedCityRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.utils.API_KEY
import kotlinx.coroutines.flow.flow

class WeatherForecastSelectedCityRepository(private val api: WeatherForecastAPI, private val weatherForecastDAO: WeatherForecastDAO): IWeatherForecastSelectedCityRepository {
    override suspend fun getCity(cityName:String)= flow {
        val currentCityResponse = api.getCity(API_KEY,cityName)
        emit(currentCityResponse)
    }
    override suspend fun getAllSavedCitiesData(): List<SavedCities> {
        val readAllSavedCities: List<SavedCities> =weatherForecastDAO.fetchCities()
        return readAllSavedCities
    }
    override suspend fun updateCity(
        id:Int,
        cityName: String,
        temp_c: String,
        temp_f: String,
        feelslike_c: String,
        feelslike_f: String,
        cityAirStatuText: String,
        cityAirStatuIcon: String) = weatherForecastDAO.updateSavedCity(id,cityName, temp_c, temp_f, feelslike_c, feelslike_f, cityAirStatuText, cityAirStatuIcon)

}