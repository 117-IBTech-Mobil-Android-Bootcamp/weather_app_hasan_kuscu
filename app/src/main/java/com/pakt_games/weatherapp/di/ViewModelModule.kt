package com.pakt_games.weatherapp.di

import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherForecastDetailViewModelModule = module {
    viewModel { WeatherForecastDetailViewModel(get()) }
}