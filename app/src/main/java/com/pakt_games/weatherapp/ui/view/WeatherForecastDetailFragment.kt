package com.pakt_games.weatherapp.ui.view

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

class WeatherForecastDetailFragment : BaseFragment<WeatherForecastDetailViewModel, FragmentWeatherForecastDetailBinding>(){

    override val viewModel: WeatherForecastDetailViewModel by viewModel()


    override fun getLayoutID() = R.layout.fragment_weather_forecast_detail

    override fun injectKoin() {
        startKoin {
            androidContext(requireActivity())
            modules(networkModule, weatherForecastDetailRepositoryModule, weatherForecastDetailViewModelModule)
        }
    }
    override fun observeLiveData() {

        viewModel.prepareMovies()

        viewModel.onMoviesFetched.observe(this, {

            dataBinding.model = it.getList()
            dataBinding.executePendingBindings()


        })


        viewModel.onError.observe(this, {

            showToast("Bir hata meydana geldi")

        })
    }

}