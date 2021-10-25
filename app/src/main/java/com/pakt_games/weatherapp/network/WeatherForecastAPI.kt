package com.pakt_games.weatherapp.network

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherForecastAPI {

    @GET("forecast.json")
     suspend fun getCity(@Query("key") apikey : String, @Query("q") cityName : String) : WeatherForecastResponse?
}