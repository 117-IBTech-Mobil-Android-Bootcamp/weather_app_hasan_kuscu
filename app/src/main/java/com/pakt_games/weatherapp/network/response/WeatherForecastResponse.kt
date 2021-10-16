package com.pakt_games.weatherapp.network.response

import com.google.gson.annotations.SerializedName
import com.pakt_games.weatherapp.ui.model.CityCurrent

data class WeatherForecastResponse(
    @SerializedName("current") val city : CityCurrent
)