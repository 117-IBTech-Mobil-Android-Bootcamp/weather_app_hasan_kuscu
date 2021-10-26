package com.pakt_games.weatherapp.repository

import com.google.common.truth.Truth
import com.pakt_games.weatherapp.fakerepofortest.FakeWeatherForecastDetailRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Test

internal class WeatherForecastDetailRepositoryTest {

    var detailRepositoryTest: FakeWeatherForecastDetailRepository? = null

    @Before
    fun setUp() {
        detailRepositoryTest = FakeWeatherForecastDetailRepository()
    }
    @Test
     fun weatherForecastDetailResponseIsNotNull() {
        runBlocking {
            detailRepositoryTest?.let {
                val detailResponse=detailRepositoryTest!!.getCityDailyPropertiesFromRemote("Bursa")
                Truth.assertThat(detailResponse).isNotNull()
            }
        }
    }
}