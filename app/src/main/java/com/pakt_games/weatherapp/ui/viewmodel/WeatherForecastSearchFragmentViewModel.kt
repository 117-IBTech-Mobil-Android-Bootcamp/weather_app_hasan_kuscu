package com.pakt_games.weatherapp.ui.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.pakt_games.weatherapp.ui.view.WeatherForecastSearchFragment

class WeatherForecastSearchFragmentViewModel: ViewModel() {
    val fragments: ArrayList<Fragment> = arrayListOf(
        WeatherForecastSearchFragment()
    )
}