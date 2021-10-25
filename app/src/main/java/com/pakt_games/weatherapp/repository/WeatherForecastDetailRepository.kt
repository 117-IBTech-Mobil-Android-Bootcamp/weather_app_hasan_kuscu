package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.utils.API_KEY
import com.pakt_games.weatherapp.utils.Result
import kotlinx.coroutines.flow.flow

class WeatherForecastDetailRepository(private val api: WeatherForecastAPI) {

    /*suspend fun getCityDailyPropertiesFromRemote(cityName:String): Result<WeatherForecastResponse> {
        val currentCityResponse = api.getCity(API_KEY, cityName)
        return if (currentCityResponse != null) {
            Result.Success(currentCityResponse)
        }
        else Result.Error(
            "Bir hata meydana geldi"
        )
    }*/
    suspend fun getCityDailyPropertiesFromRemote(cityName:String)= flow {
        val currentCityResponse = api.getCity(API_KEY,cityName)
        emit(currentCityResponse)
    }
}