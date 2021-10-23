package com.pakt_games.weatherapp.ui.view

import androidx.navigation.fragment.findNavController
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.components.CustomRegisteredCitiesPagerAdapter
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastSelectedCityBinding
import com.pakt_games.weatherapp.di.*
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSelectedCityViewModel
import com.pakt_games.weatherapp.utils.showToast
import kotlinx.android.synthetic.main.fragment_weather_forecast_selected_city.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class WeatherForecastSelectedCityFragment : BaseFragment<WeatherForecastSelectedCityViewModel,FragmentWeatherForecastSelectedCityBinding>() {

    private var index: Int = 0
    var requestedCityName: String? = null
    var list : List<SavedCities> = arrayListOf()

    override val viewModel: WeatherForecastSelectedCityViewModel by viewModel()

    override fun getLayoutID(): Int = R.layout.fragment_weather_forecast_selected_city

    override fun observeLiveData() {
        viewModel.getCityDataInSQL()
        val adapter = CustomRegisteredCitiesPagerAdapter(childFragmentManager)
        pagerHasan.adapter = adapter
        checkCityInSQLData(adapter)

        dataBinding.imageViewBackToSearchPage.setOnClickListener {
            goToSearchPage()
        }
    }

    override fun actionEvents() {
        injectKoin()
    }
    private fun checkCityInSQLData(adapter: CustomRegisteredCitiesPagerAdapter) {
        viewModel.readAllDataDB.observe(viewLifecycleOwner, { cityList->
            cityList?.let {
                for (i in 0..it.size-1) {
                    index=index.inc()
                    val fragment = WeatherForecastSelectedCityItemFragment.newInstance(i,it)
                    adapter.addFragment(fragment)
                    pagerHasan.currentItem = index
                }
            }
        })
    }
    fun injectKoin() {
        startKoin {
            androidContext(requireActivity())
            modules(
                weatherForecastSelectedCityViewModelModule,
                weatherForecastSelectedCityRepositoryModule,
                dbModule
            )
        }
    }
    fun goToSearchPage() {
        val action=WeatherForecastSelectedCityFragmentDirections.actionWeatherForecastSelectedCityFragmentToWeatherForecastSearchFragment()
        findNavController().navigate(action)
        stopKoin()
    }
}