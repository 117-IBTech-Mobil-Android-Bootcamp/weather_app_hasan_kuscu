package com.pakt_games.weatherapp.ui.model

import com.google.gson.annotations.SerializedName

data class CityForecastDay (
    @SerializedName("hour")
    val cityHours : List<CityHours>
)