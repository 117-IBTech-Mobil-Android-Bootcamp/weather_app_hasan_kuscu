package com.pakt_games.weatherapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pakt_games.weatherapp.ui.model.CityCurrent
import com.pakt_games.weatherapp.ui.model.SavedCities

@Dao
interface WeatherForecastDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(savedCity : SavedCities)

    @Query("UPDATE SAVEDCITIES SET cityName=:cityName, temp_c=:temp_c, temp_f=:temp_f, feelslike_c=:feelslike_c, feelslike_f=:feelslike_f,cityAirStatuText=:cityAirStatuText, cityAirStatuIcon=:cityAirStatuIcon WHERE id=:id")
    suspend fun updateSavedCity(id:Int,cityName: String, temp_c: String, temp_f: String, feelslike_c: String, feelslike_f: String, cityAirStatuText: String,
                                cityAirStatuIcon: String)

    @Query("SELECT * FROM SAVEDCITIES ")
    suspend fun  fetchCities() : List<SavedCities>

}