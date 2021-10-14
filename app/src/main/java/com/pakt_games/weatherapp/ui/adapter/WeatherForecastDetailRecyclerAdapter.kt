package com.pakt_games.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.weatherapp.R
import com.pakt_games.weatherapp.databinding.WeatherForecastDetailRecyclerItemBinding
import com.pakt_games.weatherapp.ui.model.CityCurrent

class WeatherForecastDetailRecyclerAdapter(private val cityList: List<CityCurrent>) : RecyclerView.Adapter<WeatherForecastDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastDetailViewHolder {

        return WeatherForecastDetailViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.weather_forecast_detail_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherForecastDetailViewHolder, position: Int) {
        val city = this.cityList[position]
        holder.populate(city)
    }

    override fun getItemCount() = this.cityList.size
}


class WeatherForecastDetailViewHolder(private val binding: WeatherForecastDetailRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun populate(city: CityCurrent) {
        binding.model = city
        binding.executePendingBindings()
    }

}