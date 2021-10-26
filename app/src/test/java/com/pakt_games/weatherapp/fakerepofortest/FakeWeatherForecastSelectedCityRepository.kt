package com.pakt_games.weatherapp.fakerepofortest

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastSelectedCityRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import kotlinx.coroutines.flow.Flow

class FakeWeatherForecastSelectedCityRepository: IWeatherForecastSelectedCityRepository {
    override suspend fun getCity(cityName: String): Flow<WeatherForecastResponse?> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllSavedCitiesData(): List<SavedCities> {
        TODO("Not yet implemented")
    }

    override suspend fun updateCity(
        id: Int,
        cityName: String,
        temp_c: String,
        temp_f: String,
        feelslike_c: String,
        feelslike_f: String,
        cityAirStatuText: String,
        cityAirStatuIcon: String
    ) {
        TODO("Not yet implemented")
    }
}