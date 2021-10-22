package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.repository.WeatherForecastSelectedCityRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import kotlinx.coroutines.launch

class WeatherForecastSelectedCityViewModel(private val weatherForecastSelectedCityRepository: WeatherForecastSelectedCityRepository) :ViewModel() {
    var readAllDataDB = MutableLiveData<List<SavedCities>>()

    fun getCityDataInSQL() {
        viewModelScope.launch {
            readAllDataDB.value = weatherForecastSelectedCityRepository.getAllSavedCitiesData()
        }
    }
}