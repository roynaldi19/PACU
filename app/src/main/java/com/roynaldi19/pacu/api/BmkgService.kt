package com.roynaldi19.pacu.api

import com.roynaldi19.pacu.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BmkgService  {
    @GET("publik/prakiraan-cuaca")
    suspend fun getWeather(
        @Query("adm4") kodeWilayah: String
    ): WeatherResponse
}