package com.pakt_games.weatherapp.ui.view

import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastSearchBinding
import com.pakt_games.weatherapp.di.*
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSearchFragmentViewModel
import com.pakt_games.weatherapp.utils.showToast
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class WeatherForecastSearchFragment : BaseFragment<WeatherForecastSearchFragmentViewModel, FragmentWeatherForecastSearchBinding>() {

    var requestedCityName: String? = null
    private var cityId:Int = 0
    /*
            ViewModel injecting
     */
    override val viewModel: WeatherForecastSearchFragmentViewModel by viewModel()

    override fun getLayoutID() = R.layout.fragment_weather_forecast_search

    /*
        Click funtions called
    */
    override fun observeLiveData() {

       dataBinding.imageViewSearchButton.setOnClickListener {
           getCityNameData()
           autoTextViewIsWork()
           dataBinding.group.visibility = View.VISIBLE
           dataBinding.buttonSaveCity.visibility = View.VISIBLE
           dataBinding.textViewWeatherForecastSearchLocationInformation.visibility = View.GONE
       }
        dataBinding.buttonSaveCity.setOnClickListener {
            val sharedPreferences = this.requireActivity().getSharedPreferences("SP", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply{ putInt("citySearchLiveId", cityId++) }.apply()
            insertCityToDatabase(sharedPreferences.getInt("citySearchLiveId",0))
            showToast("Şehriniz Başarı ile Kayıt Edilmiştir.")
        }
        dataBinding.buttonGoToCitySavedPage.setOnClickListener {
            getSavedCities()
        }
    }

    /*
        Inserting City To Database
    */
    private fun insertCityToDatabase(cityId: Int) {
        val cityName :String = dataBinding.textViewWeatherForecastSearchCityName.text.toString()
        val temp_c : String = dataBinding.textViewWeatherForecastSearchTemplatureCNumber.text.toString()
        val temp_f : String = dataBinding.textViewWeatherForecastSearchTemplatureFNumber.text.toString()
        val feelslike_c: String = dataBinding.textViewWeatherForecastSearchFeelsCNumber.text.toString()
        val feelslike_f: String = dataBinding.textViewWeatherForecastSearchFeelsFNumber.text.toString()
        val cityAirStatu: String = dataBinding.textViewWeatherForecastSearchForecastStatu.text.toString()
        val image: String=dataBinding.model!!.condition.icon
        val model = SavedCities(
            cityId,
            cityName = cityName,
            temp_c = temp_c,
            temp_f =temp_f,
            feelslike_c = feelslike_c,
            feelslike_f = feelslike_f,
            cityAirStatuText =cityAirStatu,
            cityAirStatuIcon = image
        )
        viewModel.insertCityToDB(model)

    }
    /*
        calling city name in the api
    */
    private fun getCityNameData() {
        requestedCityName = dataBinding.autoCompleteTextViewSearch.text.toString()
        if(requestedCityName!="")
            viewModel.prepareCityName(requestedCityName!!)
    }

    /*
            Working  AutoTextComplateTextView Use-cases
    */
    private fun autoTextViewIsWork() {
        viewModel.onCityNameFetched.observe(this, {
            val cityList= arrayListOf<Any>(it.cityName.name)
            val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,cityList)
            dataBinding.autoCompleteTextViewSearch.setAdapter(adapter)
            dataBinding.model = it.city
            dataBinding.executePendingBindings()
            dataBinding.textViewWeatherForecastSearchCityName.text=requestedCityName

        })
        viewModel.onError.observe(this, {
            showToast("Bir hata meydana geldi")
        })
    }

    override fun actionEvents() {
        val sharedPreferences = this.requireActivity().getSharedPreferences("SP", Context.MODE_PRIVATE)
        cityId= sharedPreferences.getInt("citySearchLiveId",0)+1
        injectKoin()
    }
    /*
        Koin injecting for dependency Injection
    */
    fun injectKoin() {
        startKoin {
            androidContext(requireActivity())
            modules(
                weatherForecastSearchViewModelModule,
                weatherForecastSearchRepositoryModule,
                networkModule,
                dbModule
            )
        }
    }
    /*
        Saving Cities
    */
    fun getSavedCities() {
        val action=WeatherForecastSearchFragmentDirections.actionWeatherForecastSearchFragmentToWeatherForecastSelectedCityFragment()
        findNavController().navigate(action)
        stopKoin()
    }
}