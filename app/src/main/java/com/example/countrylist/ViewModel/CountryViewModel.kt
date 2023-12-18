package com.example.countrylist.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.countrylist.Model.Country
import com.example.countrylist.Model.CountryRepository
import kotlinx.coroutines.Dispatchers

class CountryViewModel(private val repository: CountryRepository): ViewModel(){

    val countryList: LiveData<List<Country>> = liveData(Dispatchers.IO) {
        try {
            emit(repository.getCountries())
        }
        catch (e: Exception){
            Log.e("CountryViewModel", "There was an error getting countries: ", e)
        }
    }

}