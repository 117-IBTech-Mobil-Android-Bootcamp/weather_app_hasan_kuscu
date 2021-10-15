package com.pakt_games.weatherapp.ui.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.pakt_games.weatherapp.ui.view.WeatherForecastSearchFragment
import com.pakt_games.weatherapp.ui.view.WeatherForecastSelectedCityFragment

class WeatherForecastHomeViewModel: ViewModel() {
    val fragments: ArrayList<Fragment> = arrayListOf(
        WeatherForecastSearchFragment(),
        WeatherForecastSelectedCityFragment()
    )
}