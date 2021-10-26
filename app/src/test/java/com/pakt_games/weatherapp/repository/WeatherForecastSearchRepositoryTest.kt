package com.pakt_games.weatherapp.repository

import com.google.common.truth.Truth
import com.pakt_games.weatherapp.fakerepofortest.FakeWeatherForecastDetailRepository
import com.pakt_games.weatherapp.fakerepofortest.FakeWeatherForecastSearchRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import com.pakt_games.weatherapp.ui.model.WeatherForecastDetailViewStateModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class WeatherForecastSearchRepositoryTest{

    var searchRepositoryTest: FakeWeatherForecastSearchRepository? = null
    private lateinit var model: SavedCities

    @Before
    fun setUp() {
        searchRepositoryTest = FakeWeatherForecastSearchRepository()
        model = SavedCities(1,"Bursa","2.3","2.3","2.3","2.3","Sunny","IconImage")
    }
    @Test
    fun weatherForecastSearchResponseIsNotNull() {
        runBlocking {
            searchRepositoryTest?.let {
                val detailResponse=searchRepositoryTest!!.getCityName("Bursa")
                Truth.assertThat(detailResponse).isNotNull()
            }
        }
    }
    @Test
    fun addingAnElementToTheDatabaseAndMakingTheRespondNotNull() {
        runBlocking {
            searchRepositoryTest?.insertCityAsync(model)
            val result= searchRepositoryTest!!.cityList.size
            Truth.assertThat(result).isNotNull()
        }
    }
    @After
    fun tearDown()
    {
        model= SavedCities(0,"","","","","","","")
    }
}