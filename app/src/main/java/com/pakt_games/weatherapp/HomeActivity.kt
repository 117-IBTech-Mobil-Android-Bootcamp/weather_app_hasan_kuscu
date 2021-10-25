package com.pakt_games.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pakt_games.weatherapp.components.ConnectionLiveData
import com.pakt_games.weatherapp.utils.showToast

class HomeActivity : AppCompatActivity() {
    private lateinit var cld : ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkNetworkConnection()
    }
    private fun checkNetworkConnection() {
        cld = ConnectionLiveData(application)

        cld.observe(this, { isConnected ->

            if (isConnected){
                showToast("İnternete Bağlısınız")
            }else{
                showToast("İnternete Bağlı Değilsiniz")
            }
        })
    }
}