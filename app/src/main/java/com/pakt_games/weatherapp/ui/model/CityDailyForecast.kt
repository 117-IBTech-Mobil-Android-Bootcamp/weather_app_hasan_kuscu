package com.pakt_games.weatherapp.ui.model

import com.google.gson.annotations.SerializedName

data class CityDailyForecast (
    val forecastday: ArrayList<CityForecastDay>
)