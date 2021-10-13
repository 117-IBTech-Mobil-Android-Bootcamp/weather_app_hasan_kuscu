package com.pakt_games.weatherapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastDetailBinding
import com.pakt_games.weatherapp.di.networkModule
import com.pakt_games.weatherapp.di.weatherForecastDetailRepositoryModule
import com.pakt_games.weatherapp.di.weatherForecastDetailViewModelModule
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastDetailViewModel
import com.pakt_games.weatherapp.utils.showToast
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherForecastDetailFragment : BaseFragment<WeatherForecastDetailViewModel, FragmentWeatherForecastDetailBinding>(){

    override val viewModel: WeatherForecastDetailViewModel by viewModel()


    override fun getLayoutID() = R.layout.fragment_weather_forecast_detail

    override fun injectKoin() {
        GlobalContext.startKoin {
            androidContext(requireActivity())
            modules(networkModule, weatherForecastDetailRepositoryModule, weatherForecastDetailViewModelModule)
        }
    }
    override fun observeLiveData() {

        viewModel.prepareMovies()


        viewModel.onMoviesFetched.observe(this, {
            dataBinding.model = it.response.cityCurrent[9]
            dataBinding.executePendingBindings()
        })


        viewModel.onError.observe(this, {

            showToast("Bir hata meydana geldi")

        })
    }

}