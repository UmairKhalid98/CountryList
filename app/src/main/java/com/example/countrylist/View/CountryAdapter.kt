package com.example.countrylist.View

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countrylist.Model.Country
import com.example.countrylist.R

class CountryAdapter(private val countryList: List<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    /**
     * ViewHolder innerclass for displaying country items.
     *
     * @param countryView The view representing a country item.
     */
    class CountryViewHolder(countryView: View) : RecyclerView.ViewHolder(countryView){

        val countryName: TextView = countryView.findViewById(R.id.countryName)
        val flagImage : ImageView = countryView.findViewById(R.id.flagImage)
        val code: TextView = countryView.findViewById(R.id.code)
        val region: TextView = countryView.findViewById(R.id.region)
        val capital: TextView = countryView.findViewById(R.id.capital)
    }

    /**
     * Creates a new ViewHolder when needed.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new ViewHolder that holds a View of the given type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_item, parent, false)
        return CountryViewHolder(view)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items.
     */
    override fun getItemCount(): Int {
        return countryList.size
    }

    /**
     * Binds the data at the specified position to the given [CountryViewHolder].
     *
     * @param holder The [CountryViewHolder] in which to bind the data.
     * @param position The position of the item within the data set.
     */
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        // Get the country at the specified position
        val country = countryList[position]
        val imageUrl:String = country.flag
        // Load and display the country poster using Glide library
//        holder.flagImage.let {
//            Glide.with(it.context).load(imageUrl).override(300, 300).into(it)
//        }
        // Set country title, region and code, capital
        holder.countryName.text = country.name
        holder.capital.text = country.capital
        holder.region.text = country.region
        holder.code.text = country.code



    }
}
