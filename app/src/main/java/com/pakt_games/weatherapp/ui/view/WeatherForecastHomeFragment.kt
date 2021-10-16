package com.pakt_games.weatherapp.ui.view


import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.components.ViewPager2Adapter
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastHomeBinding
import com.pakt_games.weatherapp.di.networkModule
import com.pakt_games.weatherapp.di.weatherForecastHomeViewModelModule
import com.pakt_games.weatherapp.di.weatherForecastSearchViewModelModule
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastHomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin


class WeatherForecastHomeFragment : BaseFragment<WeatherForecastHomeViewModel,FragmentWeatherForecastHomeBinding>() {

    override val viewModel: WeatherForecastHomeViewModel by viewModel()

    override fun getLayoutID() = R.layout.fragment_weather_forecast_home

    override fun observeLiveData() {
        val viewPager2SpecialAdapter= ViewPager2Adapter(viewModel.fragments,childFragmentManager,lifecycle)
        dataBinding.viewPager2.adapter= viewPager2SpecialAdapter
    }

    override fun actionEvents() {
            injectKoin()
        }

    fun injectKoin() {
        startKoin {
            androidContext(requireActivity())
            modules(weatherForecastHomeViewModelModule,
                weatherForecastSearchViewModelModule,
                networkModule
            )
    }

}

}