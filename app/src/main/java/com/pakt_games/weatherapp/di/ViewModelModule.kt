package com.pakt_games.weatherapp.di

import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastDetailViewModel
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherForecastDetailViewModelModule = module {
    viewModel { WeatherForecastDetailViewModel(get()) }
}
val weatherForecastHomeViewModelModule = module {
    viewModel { WeatherForecastHomeViewModel() }
}