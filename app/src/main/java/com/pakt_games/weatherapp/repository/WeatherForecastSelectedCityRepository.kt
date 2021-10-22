package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.db.WeatherForecastDAO
import com.pakt_games.weatherapp.ui.model.SavedCities

class WeatherForecastSelectedCityRepository(private val weatherForecastDAO: WeatherForecastDAO) {

    suspend fun getAllSavedCitiesData(): List<SavedCities> {
        val readAllSavedCities: List<SavedCities> =weatherForecastDAO.fetchCities()
        return readAllSavedCities
    }
}