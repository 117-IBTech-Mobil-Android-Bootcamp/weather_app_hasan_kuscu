package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.base.BaseViewModel
import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.WeatherForecastSelectedCityRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherForecastSelectedCityViewModel(private val weatherForecastSelectedCityRepository: WeatherForecastSelectedCityRepository) : BaseViewModel() {
    var readAllDataDB = MutableLiveData<List<SavedCities>>()
    var onCityNameFetched = MutableLiveData<WeatherForecastResponse>()
    val onError = MutableLiveData<Unit>()
            /*
                Api Response
            */
    fun getCityProperties(cityName: String) {
        viewModelScope.launch {
            onCityNameFetched= weatherForecastSelectedCityRepository.getCity(cityName).asLiveData() as MutableLiveData<WeatherForecastResponse>
        }
    }
        /*
            get city in Database
        */
    fun getCityDataInSQL() {
        viewModelScope.launch {
            readAllDataDB.value = weatherForecastSelectedCityRepository.getAllSavedCitiesData()
        }
    }
    /*
            Update City in Database
        */
    fun updateDatabaseCityData(id:Int,cityName: String, temp_c: String, temp_f: String, feelslike_c: String, feelslike_f: String, cityAirStatuText: String,
                               cityAirStatuIcon: String) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherForecastSelectedCityRepository.updateCity(id,cityName, temp_c, temp_f, feelslike_c, feelslike_f, cityAirStatuText, cityAirStatuIcon)
        }
    }
}