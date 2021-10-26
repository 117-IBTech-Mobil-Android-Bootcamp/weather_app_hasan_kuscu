package com.pakt_games.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.databinding.WeatherForecastDetailRecyclerItemBinding
import com.pakt_games.weatherapp.ui.model.CityHours

class WeatherForecastDetailRecyclerAdapter(private val cityHourList: List<CityHours>) : RecyclerView.Adapter<WeatherForecastDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastDetailViewHolder {

        return WeatherForecastDetailViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.weather_forecast_detail_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherForecastDetailViewHolder, position: Int) {
        val city = this.cityHourList[position]
        holder.populate(city)
    }
    /*
        City Hour List Item Count
    */
    override fun getItemCount() = this.cityHourList.size
}

