package com.rondroid.explicitintenrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*

class CountryAdapter(private val arrayList:ArrayList<CountryData>):RecyclerView.Adapter<CountryAdapter.CountryViewModel>() {
    inner class CountryViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(countryViewModel: CountryViewModel){
            itemView.edTvCountry.text = countryViewModel.co
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewModel {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.countryitem_layout,parent,false)
        return CountryViewModel(inflater)
    }

    override fun onBindViewHolder(holder: CountryViewModel, position: Int) {
        val itemData = arrayList[position]
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}