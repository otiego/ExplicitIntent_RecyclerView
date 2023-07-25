package com.rondroid.explicitintenrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rondroid.explicitintenrecyclerview.databinding.ActivityRecyclerViewBinding
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var binding:ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayList = ArrayList<CountryData>()

        arrayList.add(CountryData("Kenya", "Nairobi"))
        arrayList.add(CountryData("USA", "New York"))
        arrayList.add(CountryData("Germany", "Berlin"))
        arrayList.add(CountryData("Japan", "Tokyo"))
        arrayList.add(CountryData("Mali", "Bamako"))
        arrayList.add(CountryData("Eritrea", "Asmara"))



        recyclerViewCountry.layoutManager = LinearLayoutManager(this)

        // Retrieve the country list from the intent
        val intentCountryList = intent.getParcelableArrayListExtra<CountryData>("countryList")
        if (intentCountryList != null) {
            arrayList.addAll(intentCountryList)
        }



        val myAdapter = CountryAdapter(arrayList, this)
        recyclerViewCountry.adapter = myAdapter

        binding.addingButton.setOnClickListener {
            val intent = Intent(RecyclerViewActivity@this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}