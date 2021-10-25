package com.pakt_games.weatherapp.ui.view

import android.os.Build
import androidx.navigation.fragment.findNavController
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.components.CustomRegisteredCitiesPagerAdapter
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastSelectedCityBinding
import com.pakt_games.weatherapp.di.*
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.ui.model.WeatherForecastDetailViewStateModel
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSelectedCityViewModel
import com.pakt_games.weatherapp.utils.showToast
import kotlinx.android.synthetic.main.fragment_weather_forecast_selected_city.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import java.time.LocalDateTime
import java.time.LocalDateTime.*

class WeatherForecastSelectedCityFragment : BaseFragment<WeatherForecastSelectedCityViewModel,FragmentWeatherForecastSelectedCityBinding>() {

    private var index: Int = 0
    var list : List<SavedCities> = arrayListOf()

    override val viewModel: WeatherForecastSelectedCityViewModel by viewModel()

    override fun getLayoutID(): Int = R.layout.fragment_weather_forecast_selected_city

    override fun observeLiveData() {
        viewModel.getCityDataInSQL()
        val adapter = CustomRegisteredCitiesPagerAdapter(childFragmentManager)
        pagerCities.adapter = adapter
        checkCityInSQLData(adapter)

        dataBinding.imageViewBackToSearchPage.setOnClickListener {
            goToSearchPage()
        }
    }

    override fun actionEvents() {
        injectKoin()
        updateAllRoomDatabase()
    }
    private fun checkCityInSQLData(adapter: CustomRegisteredCitiesPagerAdapter) {
        viewModel.readAllDataDB.observe(viewLifecycleOwner, { cityList->
            cityList?.let {
                for (i in 0..it.size-1) {
                    index=index.inc()
                    val fragment = WeatherForecastSelectedCityItemFragment.newInstance(i,it)
                    adapter.addFragment(fragment)
                    pagerCities.currentItem = index
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
                dbModule,
                networkModule
            )
        }
    }
    fun goToSearchPage() {
        val action=WeatherForecastSelectedCityFragmentDirections.actionWeatherForecastSelectedCityFragmentToWeatherForecastSearchFragment()
        findNavController().navigate(action)
        stopKoin()
    }
    fun updateAllRoomDatabase() {
        val nowTime: Int
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nowTime = now().hour
            showToast(nowTime.toString())
            if(true)
            {
                viewModel.readAllDataDB.observe(viewLifecycleOwner, { cityList->
                    cityList?.let {
                        for (i in 0..it.size-1) {
                            viewModel.getCityProperties(it[i].cityName)
                            viewModel.onCityNameFetched.observe(viewLifecycleOwner,{
                                updateCityInDatabase(i+1,it)
                            })
                        }
                    }
                })
            }
        }
    }
    private fun updateCityInDatabase(cityRoomId: Int,it: WeatherForecastDetailViewStateModel) {
        viewModel.updateDatabaseCityData(
            cityRoomId,
            it.getCityName(),
            it.getCity().temp_c.toString(),
            it.getCity().temp_f.toString(),
            it.getCity().feelslike_c.toString(),
            it.getCity().feelslike_f.toString(),
            it.getCity().condition.text,
            it.getCity().condition.icon
        )
    }

}