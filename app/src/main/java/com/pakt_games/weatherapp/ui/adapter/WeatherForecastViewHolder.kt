package com.pakt_games.weatherapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.weatherapp.databinding.WeatherForecastDetailRecyclerItemBinding
import com.pakt_games.weatherapp.ui.model.CityHours

class WeatherForecastDetailViewHolder(private val binding: WeatherForecastDetailRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
    /*
        Binding Cities
    */
    fun populate(city: CityHours) {
        binding.model = city
        binding.executePendingBindings()
    }
}