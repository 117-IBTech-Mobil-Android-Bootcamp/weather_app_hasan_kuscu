package com.pakt_games.weatherapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.pakt_games.weatherapp.di.networkModule
import com.pakt_games.weatherapp.di.weatherForecastSearchRepositoryModule
import com.pakt_games.weatherapp.di.weatherForecastSearchViewModelModule
import com.pakt_games.weatherapp.repository.WeatherForecastSearchRepository
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.MockitoAnnotations

internal class WeatherForecastSelectedCityViewModelTest: KoinTest {

    val viewModel: WeatherForecastSelectedCityViewModel by inject()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    lateinit var repository: WeatherForecastSearchRepository

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin {
            modules(listOf(networkModule, weatherForecastSearchRepositoryModule, weatherForecastSearchViewModelModule))
        }
    }
    @Test
    fun resultIsNotNull() {
        runBlocking {
            viewModel.getCityProperties("Bursa")
            val result = viewModel.onCityNameFetched
            Truth.assertThat(result).isNotNull()
        }
    }

    @After
    fun after() {
        stopKoin()
    }

}