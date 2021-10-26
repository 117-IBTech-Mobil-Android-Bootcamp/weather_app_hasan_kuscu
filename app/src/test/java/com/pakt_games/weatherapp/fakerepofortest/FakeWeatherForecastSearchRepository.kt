package com.pakt_games.weatherapp.fakerepofortest

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastSearchRepository
import com.pakt_games.weatherapp.ui.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeWeatherForecastSearchRepository: IWeatherForecastSearchRepository {
    var cityList: ArrayList<SavedCities> = arrayListOf()

    override suspend fun getCityName(cityName: String): Flow<WeatherForecastResponse?> = flow {
        val fakeDataResponse= WeatherForecastResponse(
            CityCurrent(0,2.3,3.3,3.3,4.3, CityCondition("Sunny","Icon")),
            CityLocation(cityName,"24"),
            CityDailyForecast(arrayListOf())
        )
        emit(fakeDataResponse)
    }

    override suspend fun insertCityAsync(savedCities: SavedCities) {
        cityList.add(savedCities)
    }

}