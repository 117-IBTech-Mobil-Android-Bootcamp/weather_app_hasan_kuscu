package com.pakt_games.weatherapp.ui.model

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse

data class WeatherForecastDetailViewStateModel(val response: WeatherForecastResponse) {

    fun getList(): CityCurrent = response.movies

}