package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.repository.WeatherForecastDetailRepository
import com.pakt_games.weatherapp.ui.model.WeatherForecastDetailViewStateModel
import kotlinx.coroutines.launch
import com.pakt_games.weatherapp.utils.Result

class WeatherForecastDetailViewModel(private val weatherForecastDetailRepository: WeatherForecastDetailRepository) : ViewModel() {


    val onCityFetched = MutableLiveData<WeatherForecastDetailViewStateModel>()
    val onError = MutableLiveData<Unit>()

    fun prepareCity(cityName: String) {

        viewModelScope.launch {
            val remoteResponse = weatherForecastDetailRepository.getCityPropertiesFromRemote(cityName)
            when(remoteResponse){
                is Result.Success -> {
                    onCityFetched.value = WeatherForecastDetailViewStateModel(remoteResponse.data!!)
                }
                is Result.Error -> onError.value = Unit
            }

        }
    }
}