package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.db.WeatherForecastDatabase
import com.pakt_games.weatherapp.repository.WeatherForecastSearchRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.ui.model.WeatherForecastDetailViewStateModel
import com.pakt_games.weatherapp.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherForecastSearchFragmentViewModel(private val weatherForecastDetailRepository: WeatherForecastSearchRepository) : ViewModel() {

    val onCityNameFetched = MutableLiveData<WeatherForecastDetailViewStateModel>()
    val onError = MutableLiveData<Unit>()

    fun prepareCityName(cityName: String) {

        viewModelScope.launch {
            val remoteResponse = weatherForecastDetailRepository.getCityName(cityName)
            when(remoteResponse){
                is Result.Success -> {
                    onCityNameFetched.value = WeatherForecastDetailViewStateModel(remoteResponse.data!!)
                }
                is Result.Error -> onError.value = Unit
            }

        }
    }
    fun insertCityToDB(savedCities: SavedCities) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherForecastDetailRepository.insertCityAsync(savedCities)
        }
    }
}