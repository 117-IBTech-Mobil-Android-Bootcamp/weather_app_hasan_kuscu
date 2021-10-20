package com.pakt_games.weatherapp.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pakt_games.weatherapp.R
import java.io.FileDescriptor.out
import java.lang.System.out

fun ImageView.downloadImage(url:String?, placeholder: CircularProgressDrawable) {
    //if  image to late coming this screen
    try {
        val options= RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher)
        Glide.with(context).setDefaultRequestOptions(options).load(url!!.castedUrl()).into(this)
    } catch (exeption:Exception) {
        //Exeption
    }
}
fun String.castedUrl(baseUrl:String?="https:"):String {
    return baseUrl+this
}

// create progressBar for PlaceHolder
fun createPlaceholder(contex: Context): CircularProgressDrawable {
    return CircularProgressDrawable(contex).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }
}
@BindingAdapter("android:downloadImage")
fun downloadBindingImage(view: ImageView, url: String?) {
    view.downloadImage(url, createPlaceholder(view.context))
}