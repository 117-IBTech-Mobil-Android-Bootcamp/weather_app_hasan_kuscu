package com.pakt_games.weatherapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.utils.createPlaceholder
import com.pakt_games.weatherapp.utils.downloadImage
import kotlinx.android.synthetic.main.fragment_weather_forecast_search.view.*
import kotlinx.android.synthetic.main.fragment_weather_forecast_selected_city_item.view.*
import org.koin.core.context.stopKoin


class WeatherForecastSelectedCityItemFragment : Fragment() {

    private var cityAirStatuText = ""
    private var cityName = ""
    private var cityCelsiusValue =""
    private var cityFahrenaytValue =""
    private var cityFellslikeCelsiusValue =""
    private var cityFellslikeFahrenaytValue =""
    private var cityAirIcon=""
    protected lateinit var dataBinding: ViewDataBinding

    companion object {
        fun newInstance(i: Int,list: List<SavedCities>): WeatherForecastSelectedCityItemFragment {
            val fragment = WeatherForecastSelectedCityItemFragment()
            val bundle = Bundle()
            bundle.putString("cityName", list[i].cityName)
            bundle.putString("cityAirStatuText", list[i].cityAirStatuText)
            bundle.putString("cityCelsiusValue", list[i].temp_c)
            bundle.putString("cityFahrenaytValue", list[i].temp_f)
            bundle.putString("cityFellslikeCelsiusValue", list[i].feelslike_c)
            bundle.putString("cityFellslikeFahrenaytValue", list[i].feelslike_f)
            bundle.putString("cityAirIcon", list[i].cityAitStatuIcon)
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityAirStatuText = arguments?.getString("cityAirStatuText").toString()
        cityName = arguments?.getString("cityName").toString()
        cityCelsiusValue = arguments?.getString("cityCelsiusValue").toString()
        cityFahrenaytValue = arguments?.getString("cityFahrenaytValue").toString()
        cityFellslikeCelsiusValue = arguments?.getString("cityFellslikeCelsiusValue").toString()
        cityFellslikeFahrenaytValue = arguments?.getString("cityFellslikeFahrenaytValue").toString()
        cityAirIcon = arguments?.getString("cityAirIcon").toString()

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_forecast_selected_city_item, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.textViewCityName.text = cityName
        view.textViewWeatherForecastSelectedCityCelsiusValue.text = cityCelsiusValue
        view.textViewWeatherForecastSelectedCityFahrenaytValue.text = cityFahrenaytValue
        view.textViewWeatherForecastSelectedCityFeelslikeCelsiusValue.text = cityFellslikeCelsiusValue
        view.textViewWeatherForecastSelectedCityFeelslikeFahrenaytValue.text = cityFellslikeFahrenaytValue
        view.textViewCityAirStatuText.text = cityAirStatuText
        view.imageViewAirStatuIcon.downloadImage(cityAirIcon, createPlaceholder(view.context))

        view.buttonGoToCityDetailPage.setOnClickListener {
            val action=WeatherForecastSelectedCityFragmentDirections.actionWeatherForecastSelectedCityFragmentToWeatherForecastDetailFragment(view.textViewCityName.text.toString())
            findNavController().navigate(action)
            stopKoin()
        }
    }
}