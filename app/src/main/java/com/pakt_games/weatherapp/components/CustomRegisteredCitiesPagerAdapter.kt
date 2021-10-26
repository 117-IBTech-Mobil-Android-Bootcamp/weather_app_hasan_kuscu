package com.pakt_games.weatherapp.components

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CustomRegisteredCitiesPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {

    private val fragments = ArrayList<Fragment>()
    /*
        My Fragmnets items position
    */
    override fun getItem(position: Int) : Fragment = fragments[position]
    /*
        My Fragmnets count
    */
    override fun getCount(): Int = fragments.size
    /*
       Creating my Fragments
    */
    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }
}