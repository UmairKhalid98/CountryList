package com.example.countrylist.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylist.Model.CountryRepository
import com.example.countrylist.R
import com.example.countrylist.ViewModel.CountryViewModel
import com.example.countrylist.ViewModel.CountryViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CountryViewModel
    private lateinit var adapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Creating CountryRepository and ViewModelFactory instances
        val repository = CountryRepository()
        val factory = CountryViewModelFactory(repository)

        // Initializing CountryViewModel using ViewModelProvider
        viewModel = ViewModelProvider(this, factory).get(CountryViewModel::class.java)
        // Initializing RecyclerView and its layout manager
        adapter = CountryAdapter(viewModel.countryList.value ?:listOf())
        val recyclerView: RecyclerView = findViewById(R.id.countryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE
        // Observing changes in the countryList LiveData from the ViewModel

        viewModel.countryList.observe(this) { countries ->
            if (countries != null) {
                progressBar.visibility = View.GONE
            }
            // Updating the adapter with the latest list of countries
            adapter = countries?.let { CountryAdapter(it) }!!
            recyclerView.adapter = adapter
        }

    }

    }
