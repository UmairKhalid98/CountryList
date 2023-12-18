package com.example.countrylist.Model

import android.util.Log
import com.example.countrylist.Services.CountryApi
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryRepository() {

    val gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val service = retrofit.create(CountryApi::class.java)

    suspend fun getCountries(): List<Country> = withContext(Dispatchers.IO) {
        try {
            val response = service.getCountriesApi()
            if (response.isSuccessful) {
                response.body() ?: listOf()
            } else {
                listOf()
            }
        } catch (e: Exception) {
            Log.e("CountryRepository", "Error fetching countries", e)
            listOf()
        }
    }
}

