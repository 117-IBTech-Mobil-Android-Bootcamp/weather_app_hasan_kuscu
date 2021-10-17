package com.pakt_games.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakt_games.weatherapp.repository.WeatherForecastDetailRepository
import com.pakt_games.weatherapp.ui.model.WeatherForecastDetailViewStateModel
import kotlinx.coroutines.launch
import com.pakt_games.weatherapp.utils.Result

class WeatherForecastDetailViewModel(private val weatherForecastDetailRepository: WeatherForecastDetailRepository) : ViewModel() {


    val onMoviesFetched = MutableLiveData<WeatherForecastDetailViewStateModel>()
    val onError = MutableLiveData<Unit>()

    fun prepareMovies(cityName: String) {

        viewModelScope.launch {
            val remoteResponse = weatherForecastDetailRepository.getCityPropertiesFromRemote(cityName)
            when(remoteResponse){
                is Result.Success -> {
                    onMoviesFetched.value = WeatherForecastDetailViewStateModel(remoteResponse.data!!)
                }
                is Result.Error -> onError.value = Unit
            }

        }
    }
}