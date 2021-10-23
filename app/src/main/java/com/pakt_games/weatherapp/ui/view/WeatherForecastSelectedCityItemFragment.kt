package com.pakt_games.weatherapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.ui.model.SavedCities
import kotlinx.android.synthetic.main.fragment_weather_forecast_selected_city_item.view.*


class WeatherForecastSelectedCityItemFragment : Fragment() {

    private var textFragment = ""
    private var hasanTEXT = ""
    protected lateinit var dataBinding: ViewDataBinding

    companion object {
        fun newInstance(i: Int,list: List<SavedCities>): WeatherForecastSelectedCityItemFragment {
            val fragment = WeatherForecastSelectedCityItemFragment()
            val bundle = Bundle()
            bundle.putString("textNumber", list[i].cityName)
            bundle.putString("textName", list[i].cityAirStatuText)
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textFragment = arguments?.getString("textNumber").toString()
        hasanTEXT = arguments?.getString("textName").toString()

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_forecast_selected_city_item, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tvFragment.text=textFragment
        view.hasanTEXT.text=hasanTEXT
        view.hasanTEXT.setOnClickListener {
            Toast.makeText(requireContext(),"Tıklandı", Toast.LENGTH_LONG).show()
        }
    }
}