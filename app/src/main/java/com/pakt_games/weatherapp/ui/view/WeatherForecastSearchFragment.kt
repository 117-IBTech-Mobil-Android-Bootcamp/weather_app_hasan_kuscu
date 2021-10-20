package com.pakt_games.weatherapp.ui.view

import android.view.View
import android.widget.ArrayAdapter
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.base.BaseFragment
import com.pakt_games.weatherapp.databinding.FragmentWeatherForecastSearchBinding
import com.pakt_games.weatherapp.ui.viewmodel.WeatherForecastSearchFragmentViewModel
import com.pakt_games.weatherapp.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherForecastSearchFragment : BaseFragment<WeatherForecastSearchFragmentViewModel, FragmentWeatherForecastSearchBinding>() {

    var requestedCityName: String? = null

    override val viewModel: WeatherForecastSearchFragmentViewModel by viewModel()

    override fun getLayoutID() = R.layout.fragment_weather_forecast_search

    override fun observeLiveData() {
       dataBinding.imageViewSearchButton.setOnClickListener {
           autoTextViewIsWork()
           dataBinding.group.visibility = View.VISIBLE
       }

    }

    private fun autoTextViewIsWork() {
        requestedCityName = dataBinding.autoCompleteTextViewSearch.text.toString()
        if(requestedCityName!="")
            viewModel.prepareCityName(requestedCityName!!)
        viewModel.onCityNameFetched.observe(this, {
            var cityList= arrayListOf<Any>(it.getCityName())
            var adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,cityList)
            dataBinding.autoCompleteTextViewSearch.setAdapter(adapter)
            dataBinding.model = it.getCity()
            dataBinding.executePendingBindings()
            dataBinding.textViewWeatherForecastSearchCityName.text=requestedCityName

        })
        viewModel.onError.observe(this, {
            showToast("Bir hata meydana geldi")
        })
    }

    override fun actionEvents() {

    }

}