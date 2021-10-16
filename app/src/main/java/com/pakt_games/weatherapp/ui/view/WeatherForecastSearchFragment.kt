package com.pakt_games.weatherapp.ui.view

import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastSearchBinding
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSearchFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherForecastSearchFragment : BaseFragment<WeatherForecastSearchFragmentViewModel, FragmentWeatherForecastSearchBinding>() {

    override val viewModel: WeatherForecastSearchFragmentViewModel by viewModel()

    override fun getLayoutID() = R.layout.fragment_weather_forecast_search

    override fun observeLiveData() {

    }

    override fun actionEvents() {

    }

}