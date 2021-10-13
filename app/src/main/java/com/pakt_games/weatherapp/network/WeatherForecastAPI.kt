package com.pakt_games.weatherapp.network

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherForecastAPI {

    @GET("{city_name}")
    fun getCities(@Path("city_name") cityName: String) :WeatherForecastResponse

}