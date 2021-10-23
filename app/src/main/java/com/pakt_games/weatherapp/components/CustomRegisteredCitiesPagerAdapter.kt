package com.pakt_games.weatherapp.components

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CustomRegisteredCitiesPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {

    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getItem(position: Int) : Fragment = fragments[position]

    override fun getPageTitle(position: Int): CharSequence =titles[position]

    override fun getCount(): Int = fragments.size

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }
}