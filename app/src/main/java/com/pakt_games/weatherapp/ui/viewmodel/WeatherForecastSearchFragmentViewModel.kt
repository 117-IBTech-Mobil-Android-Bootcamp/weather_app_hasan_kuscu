package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.base.BaseViewModel
import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.WeatherForecastSearchRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherForecastSearchFragmentViewModel(private val weatherForecastSearchRepository: WeatherForecastSearchRepository) :  BaseViewModel() {

    var onCityNameFetched = MutableLiveData<WeatherForecastResponse>()
    val onError = MutableLiveData<Unit>()

    fun prepareCityName(cityName: String) {
        viewModelScope.launch {
            onCityNameFetched= weatherForecastSearchRepository.getCityName(cityName).asLiveData() as MutableLiveData<WeatherForecastResponse>
        }
    }
    fun insertCityToDB(savedCities: SavedCities) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherForecastSearchRepository.insertCityAsync(savedCities)
        }
    }
}