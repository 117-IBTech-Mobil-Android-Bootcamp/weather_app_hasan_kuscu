package com.pakt_games.weatherapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.google.common.truth.Truth
import com.pakt_games.weatherapp.di.networkModule
import com.pakt_games.weatherapp.di.weatherForecastDetailRepositoryModule
import com.pakt_games.weatherapp.di.weatherForecastDetailViewModelModule
import com.pakt_games.weatherapp.repository.WeatherForecastDetailRepository
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.MockitoAnnotations

internal class WeatherForecastDetailViewModelTest : KoinTest{

     val viewModel: WeatherForecastDetailViewModel by inject()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    lateinit var repository: WeatherForecastDetailRepository

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin {
            modules(listOf(networkModule, weatherForecastDetailRepositoryModule, weatherForecastDetailViewModelModule))
        }
    }
    @Test
    fun resultIsNotNull() {
        runBlocking {
            viewModel.prepareCity("Bursa")
            val result = viewModel.onCityFetched
            Truth.assertThat(result).isNotNull()
        }
    }

    @After
    fun after() {
        stopKoin()
    }

}