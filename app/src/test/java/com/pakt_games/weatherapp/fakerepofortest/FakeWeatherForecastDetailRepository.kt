package com.pakt_games.weatherapp.fakerepofortest

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastDetailRepository
import com.pakt_games.weatherapp.ui.model.CityCondition
import com.pakt_games.weatherapp.ui.model.CityCurrent
import com.pakt_games.weatherapp.ui.model.CityDailyForecast
import com.pakt_games.weatherapp.ui.model.CityLocation
import kotlinx.coroutines.flow.flow

class FakeWeatherForecastDetailRepository: IWeatherForecastDetailRepository {
    override suspend fun getCityDailyPropertiesFromRemote(cityName:String)= flow{
        val fakeDataResponse= WeatherForecastResponse(
            CityCurrent(0,2.3,3.3,3.3,4.3, CityCondition("Sunny","Icon")),
            CityLocation("Bursa","24"),
            CityDailyForecast(arrayListOf())
        )
        emit(fakeDataResponse)
    }
}