package com.pakt_games.weatherapp.components

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pakt_games.weatherapp.ui.view.WeatherForecastSearchFragment
import com.pakt_games.weatherapp.ui.view.WeatherForecastSelectedCityFragment

class ViewPager2Adapter(fragmentManager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return WeatherForecastSearchFragment()
            1 -> return WeatherForecastSelectedCityFragment()
            else -> return WeatherForecastSearchFragment()
        }
    }

}