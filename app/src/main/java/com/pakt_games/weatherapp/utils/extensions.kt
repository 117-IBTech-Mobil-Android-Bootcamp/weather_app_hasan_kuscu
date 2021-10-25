package com.pakt_games.weatherapp.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(messageToShow : String){
    Toast.makeText(requireContext(), messageToShow, Toast.LENGTH_LONG).show()
}
fun Activity.showToast(messageToShow : String){
    Toast.makeText(this, messageToShow, Toast.LENGTH_LONG).show()
}