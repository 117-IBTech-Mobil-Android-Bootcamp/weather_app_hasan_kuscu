package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.repository.WeatherForecastSelectedCityRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.ui.model.WeatherForecastDetailViewStateModel
import com.pakt_games.weatherapp.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherForecastSelectedCityViewModel(private val weatherForecastSelectedCityRepository: WeatherForecastSelectedCityRepository) :ViewModel() {
    var readAllDataDB = MutableLiveData<List<SavedCities>>()
    val onCityNameFetched = MutableLiveData<WeatherForecastDetailViewStateModel>()
    val onError = MutableLiveData<Unit>()

    fun getCityProperties(cityName: String) {
        viewModelScope.launch {
            val remoteResponse = weatherForecastSelectedCityRepository.getCityPropertiesForUpdateDatabase(cityName)
            when(remoteResponse){
                is Result.Success -> {
                    onCityNameFetched.value = WeatherForecastDetailViewStateModel(remoteResponse.data!!)
                }
                is Result.Error -> onError.value = Unit
            }
        }
    }
    fun getCityDataInSQL() {
        viewModelScope.launch {
            readAllDataDB.value = weatherForecastSelectedCityRepository.getAllSavedCitiesData()
        }
    }
    fun updateDatabaseCityData(id:Int,cityName: String, temp_c: String, temp_f: String, feelslike_c: String, feelslike_f: String, cityAirStatuText: String,
                               cityAirStatuIcon: String) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherForecastSelectedCityRepository.updateCity(id,cityName, temp_c, temp_f, feelslike_c, feelslike_f, cityAirStatuText, cityAirStatuIcon)
        }
    }
}