package com.pakt_games.weatherapp.repository

import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.utils.API_KEY
import com.pakt_games.weatherapp.utils.Result

class WeatherForecastDetailRepository(private val api: WeatherForecastAPI) {

    suspend fun getAllMoviesFromRemote(cityName:String): Result<WeatherForecastResponse> {
        val currentCityResponse = api.getCity(API_KEY, cityName)
        return if (currentCityResponse != null) {
            Result.Success(currentCityResponse)
        }
        else Result.Error(
            "bir hata meydana geldi"
        )
    }
}