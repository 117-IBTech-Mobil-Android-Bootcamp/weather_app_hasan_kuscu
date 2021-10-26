package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.WeatherForecastDetailRepository
import kotlinx.coroutines.launch

class WeatherForecastDetailViewModel(private val weatherForecastDetailRepository: WeatherForecastDetailRepository) : ViewModel() {


    var onCityFetched = MutableLiveData<WeatherForecastResponse>()
    val onError = MutableLiveData<Unit>()

    fun prepareCity(cityName: String) {
        viewModelScope.launch {
            onCityFetched=weatherForecastDetailRepository.getCityDailyPropertiesFromRemote(cityName).asLiveData() as MutableLiveData<WeatherForecastResponse>
        }
    }

}