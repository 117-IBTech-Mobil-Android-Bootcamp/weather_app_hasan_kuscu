package com.pakt_games.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import com.pakt_games.weatherapp.utils.startActivity

class SplashActivity : AppCompatActivity() {
    //Waiting 3 sec. for Splash Activity
    private val DELAY: Long=3*1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Timer Thread
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity<HomeActivity>()
                //destroyed splash activitiy
                finish()
            }
        }, DELAY)
    }
}