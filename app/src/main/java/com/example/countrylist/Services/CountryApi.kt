package com.example.countrylist.Services

import com.example.countrylist.Model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {
    @GET("countries.json")
    suspend fun getCountriesApi(): Response<List<Country>>

}

