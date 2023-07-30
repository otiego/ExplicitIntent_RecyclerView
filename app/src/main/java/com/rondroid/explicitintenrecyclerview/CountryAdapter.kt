package com.rondroid.explicitintenrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.countryitem_layout.view.*

class CountryAdapter(private val countryArrayList:ArrayList<CountryData>, val context: Context):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){

    inner class CountryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bindItems(countryData: CountryData){
            itemView.item_countryTv.text = countryData.country
            itemView.item_countryCapitalTv.text = countryData.capital
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.countryitem_layout,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindItems(countryArrayList[position])
    }

    override fun getItemCount(): Int {
        return countryArrayList.size
    }
}