package com.pakt_games.weatherapp.ui.view

import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastSelectedCityBinding
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSelectedCityViewModel
import com.pakt_games.weatherapp.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherForecastSelectedCityFragment : BaseFragment<WeatherForecastSelectedCityViewModel,FragmentWeatherForecastSelectedCityBinding>() {
    var requestedCityName: String? = null

    override val viewModel: WeatherForecastSelectedCityViewModel by viewModel()

    override fun getLayoutID(): Int = R.layout.fragment_weather_forecast_selected_city

    override fun observeLiveData() {
        viewModel.getCityDataInSQL()
        checkCityInSQLData()
    }

    override fun actionEvents() {
        //TODO
    }
    private fun checkCityInSQLData() {
        viewModel.readAllDataDB.observe(viewLifecycleOwner, { cityList->
            cityList?.let {
                var hasan=it.size
            }
        })
    }
}