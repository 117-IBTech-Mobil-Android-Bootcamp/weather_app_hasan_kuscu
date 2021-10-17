package com.pakt_games.weatherapp.ui.model

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse

data class WeatherForecastDetailViewStateModel(val response: WeatherForecastResponse) {

    fun getCity(): CityCurrent = response.city
    fun getCityName(): CityLocation=response.cityName

}