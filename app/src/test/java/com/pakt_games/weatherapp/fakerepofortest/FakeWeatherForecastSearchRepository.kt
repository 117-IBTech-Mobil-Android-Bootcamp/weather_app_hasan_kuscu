package com.pakt_games.weatherapp.fakerepofortest

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastSearchRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import kotlinx.coroutines.flow.Flow

class FakeWeatherForecastSearchRepository:IWeatherForecastSearchRepository {
    override suspend fun getCityName(cityName: String): Flow<WeatherForecastResponse?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCityAsync(savedCities: SavedCities) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTable() {
        TODO("Not yet implemented")
    }
}