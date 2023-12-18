package com.example.countrylist.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countrylist.Model.CountryRepository

class CountryViewModelFactory (private val repository: CountryRepository) : ViewModelProvider.Factory {
    /**
     * Creates a new instance of the specified ViewModel.
     *
     * @param modelClass The class of the ViewModel to create.
     * @return A newly created instance of the specified ViewModel.
     * @throws IllegalArgumentException If the specified [Country] is not assignable from [CountryViewModel].
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}