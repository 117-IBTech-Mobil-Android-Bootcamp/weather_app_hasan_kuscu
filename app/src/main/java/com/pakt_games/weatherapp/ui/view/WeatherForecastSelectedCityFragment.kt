package com.pakt_games.weatherapp.ui.view

import android.os.Build
import androidx.navigation.fragment.findNavController
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.components.CustomRegisteredCitiesPagerAdapter
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastSelectedCityBinding
import com.pakt_games.weatherapp.di.*
import com.pakt_games.weatherapp.ui.model.CityCurrent
import com.pakt_games.weatherapp.ui.model.CityLocation
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
    var cityList: List<SavedCities> = arrayListOf()

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
        /*
           checking City in the Database
        */
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
    /*
          Injection Koin for dependency injection
    */
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
    /*
        Go to Search Page
    */
    fun goToSearchPage() {
        val action=WeatherForecastSelectedCityFragmentDirections.actionWeatherForecastSelectedCityFragmentToWeatherForecastSearchFragment()
        findNavController().navigate(action)
        stopKoin()
    }
        /*
            1- Getting database data in the Room database
            2- Responding city name to api
            3- Calling api
            4- Updating city in the Room database
        */
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
                                updateCityInDatabase(i+1,it.cityName,it.city)
                            })
                        }
                    }
                })
            }
        }
    }
    private fun updateCityInDatabase(cityRoomId: Int,cityName: CityLocation,cityCurrent: CityCurrent) {
        viewModel.updateDatabaseCityData(
            cityRoomId,
            cityName.name,
            cityCurrent.temp_c.toString(),
            cityCurrent.temp_f.toString(),
            cityCurrent.feelslike_c.toString(),
            cityCurrent.feelslike_f.toString(),
            cityCurrent.condition.text,
            cityCurrent.condition.icon
        )
    }

}