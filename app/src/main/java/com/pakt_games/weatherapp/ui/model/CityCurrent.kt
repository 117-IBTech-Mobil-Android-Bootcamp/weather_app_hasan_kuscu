package com.pakt_games.weatherapp.ui.model

data class CityCurrent(
    val temp_c : Double,
    val temp_f : Double,
    val feelslike_c : Double,
    val feelslike_f : Double,
    val condution : CityCondution
)
