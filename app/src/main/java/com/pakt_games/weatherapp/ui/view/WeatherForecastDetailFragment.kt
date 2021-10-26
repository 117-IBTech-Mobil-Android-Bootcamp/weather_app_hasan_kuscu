package com.pakt_games.weatherapp.ui.view

import androidx.navigation.fragment.findNavController
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastDetailBinding
import com.pakt_games.weatherapp.di.networkModule
import com.pakt_games.weatherapp.di.weatherForecastDetailRepositoryModule
import com.pakt_games.weatherapp.di.weatherForecastDetailViewModelModule
import com.pakt_games.weatherapp.ui.adapter.WeatherForecastDetailRecyclerAdapter
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastDetailViewModel
import com.pakt_games.weatherapp.utils.showToast
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class WeatherForecastDetailFragment : BaseFragment<WeatherForecastDetailViewModel, FragmentWeatherForecastDetailBinding>(){
    var requestedCityName: String? = null
    private var movieTitle ="TEST"

    override val viewModel: WeatherForecastDetailViewModel by viewModel()

    override fun getLayoutID() = R.layout.fragment_weather_forecast_detail

    override fun actionEvents() {
        startKoin {
            androidContext(requireActivity())
            modules(networkModule, weatherForecastDetailRepositoryModule, weatherForecastDetailViewModelModule)
        }
    }
    fun getSingleMovieData()
    {
        arguments?.let {
            requestedCityName = WeatherForecastDetailFragmentArgs.fromBundle(it).cityName
        }
        requestedCityName?.let { viewModel.prepareCity(it) }

    }
    override fun observeLiveData() {
        getSingleMovieData()
        viewModel.onCityFetched.observe(this, {
            dataBinding.model=it.cityName
            dataBinding.recyclerviewWeatherForecastDetail.adapter = WeatherForecastDetailRecyclerAdapter(it.cityDaily.forecastday[0].cityHours)
            dataBinding.executePendingBindings()
        })
        dataBinding.imageViewGoToSelectedPage.setOnClickListener {
            goToSelectedPage()
        }
    }
    fun goToSelectedPage() {
        val action = WeatherForecastDetailFragmentDirections.actionWeatherForecastDetailFragmentToWeatherForecastSelectedCityFragment()
        findNavController().navigate(action)
        stopKoin()
    }

}