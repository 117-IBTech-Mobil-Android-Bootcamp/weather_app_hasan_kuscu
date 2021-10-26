package com.pakt_games.weatherapp.di

import com.pakt_games.weatherapp.network.WeatherForecastAPI
import com.pakt_games.weatherapp.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*
    NetworkModules for Dependecy Injection
*/
val networkModule = module {
    factory { provideHttpClient() }
    single { provideCityApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideHttpClient() : OkHttpClient {
    //logging interceptor
    val logging = HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
    //adding logging interceptor to okhttp
    val httpClient: OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()

    return httpClient
}
fun provideRetrofit(httpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}
/*
    Weather Forecast API
*/
fun provideCityApi(retrofit: Retrofit) : WeatherForecastAPI {
    return  retrofit.create(WeatherForecastAPI::class.java)
}