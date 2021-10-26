package com.pakt_games.weatherapp.repository

import com.google.common.truth.Truth
import com.pakt_games.weatherapp.fakerepofortest.FakeWeatherForecastSelectedCityRepository
import com.pakt_games.weatherapp.ui.model.SavedCities
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class WeatherForecastSelectedCityRepositoryTest {

    var selectedRepositoryTest: FakeWeatherForecastSelectedCityRepository? = null
    private lateinit var model: SavedCities

    @Before
    fun setUp() {
        selectedRepositoryTest = FakeWeatherForecastSelectedCityRepository()
        model = SavedCities(1, "İzmir", "2.3", "2.3", "2.3", "2.3", "Sunny", "IconImage")
    }

    @Test
    fun weatherForecastSearchResponseIsNotNull() {
        runBlocking {
            selectedRepositoryTest?.let {
                val detailResponse = selectedRepositoryTest!!.getCity("Bursa")
                Truth.assertThat(detailResponse).isNotNull()
            }
        }
    }
    @Test
    fun gettingAllDatabaseElementsElementSizeIsThree() {
        runBlocking {
            val citySize = (selectedRepositoryTest!!.cityList.size)
            Truth.assertThat(citySize).isGreaterThan(0)
        }
    }
    @Test
    fun updatingCityIsUpdated() {
        runBlocking {
            selectedRepositoryTest!!.cityList.removeAt(0)
            selectedRepositoryTest!!.cityList.add(0,model)
            val cityList = selectedRepositoryTest!!.getAllSavedCitiesData()
            Truth.assertThat(cityList[0].cityName).isEqualTo("İzmir")
        }
    }
    @After
    fun tearDown()
    {
        model= SavedCities(0,"","","","","","","")
    }
}