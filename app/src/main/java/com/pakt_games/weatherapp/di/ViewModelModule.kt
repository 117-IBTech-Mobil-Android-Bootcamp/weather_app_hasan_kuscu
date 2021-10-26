package com.pakt_games.weatherapp.di

import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastDetailViewModel
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSearchFragmentViewModel
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSelectedCityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
/*
    ViewModelModules for Dependecy Injection
*/
val weatherForecastDetailViewModelModule = module {
    viewModel { WeatherForecastDetailViewModel(get()) }
}
val weatherForecastSearchViewModelModule = module {
    viewModel { WeatherForecastSearchFragmentViewModel(get()) }
}
val weatherForecastSelectedCityViewModelModule = module {
    viewModel { WeatherForecastSelectedCityViewModel(get()) }
}