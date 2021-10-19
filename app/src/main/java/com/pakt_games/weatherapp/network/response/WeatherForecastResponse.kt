package com.pakt_games.weatherapp.network.response

import com.google.gson.annotations.SerializedName
import com.pakt_games.weatherapp.ui.model.CityCurrent
import com.pakt_games.weatherapp.ui.model.CityDailyForecast
import com.pakt_games.weatherapp.ui.model.CityLocation

data class WeatherForecastResponse(
    @SerializedName("current") val city : CityCurrent,
    @SerializedName("location") val cityName: CityLocation,
    @SerializedName("forecast") val cityDaily: CityDailyForecast
)