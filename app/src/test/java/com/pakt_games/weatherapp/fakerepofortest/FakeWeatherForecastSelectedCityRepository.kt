package com.pakt_games.weatherapp.fakerepofortest

import com.pakt_games.weatherapp.network.response.WeatherForecastResponse
import com.pakt_games.weatherapp.repository.RepositoryInterfaces.IWeatherForecastSelectedCityRepository
import com.pakt_games.weatherapp.ui.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeWeatherForecastSelectedCityRepository: IWeatherForecastSelectedCityRepository {
    val cityList: ArrayList<SavedCities> = arrayListOf(
        SavedCities(1,"Bursa","2.3","2.3","2.3","2.3","Sunny","IconImage"),
        SavedCities(2,"Ankara","2.3","2.3","2.3","2.3","Sunny","IconImage"),
        SavedCities(3,"İstanbul","2.3","2.3","2.3","2.3","Sunny","IconImage")
    )

    override suspend fun getCity(cityName: String): Flow<WeatherForecastResponse?> =flow  {
        val fakeDataResponse= WeatherForecastResponse(
            CityCurrent(0,2.3,3.3,3.3,4.3, CityCondition("Sunny","Icon")),
            CityLocation(cityName,"24"),
            CityDailyForecast(arrayListOf())
        )
        emit(fakeDataResponse)
    }

    override suspend fun getAllSavedCitiesData(): List<SavedCities> {
        return cityList
    }

    override suspend fun updateCity(
        id: Int,
        cityName: String,
        temp_c: String,
        temp_f: String,
        feelslike_c: String,
        feelslike_f: String,
        cityAirStatuText: String,
        cityAirStatuIcon: String
    ) {
        cityList[0].cityName=cityName
    }
}