package com.pakt_games.weatherapp.ui.model

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse

data class WeatherForecastDetailViewStateModel(val response: WeatherForecastResponse) {

    fun getCity(): CityCurrent = response.city
    fun getCityName(): String=response.cityName.name
    fun getDailyCity(): List<CityHours> = response.cityDaily.forecastday[0].cityHours
}