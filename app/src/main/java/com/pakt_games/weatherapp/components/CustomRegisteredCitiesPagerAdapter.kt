package com.pakt_games.weatherapp.components

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CustomRegisteredCitiesPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {

    private val fragments = ArrayList<Fragment>()

    override fun getItem(position: Int) : Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }
}