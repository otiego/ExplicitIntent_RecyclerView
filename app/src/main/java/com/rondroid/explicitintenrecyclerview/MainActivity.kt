package com.rondroid.explicitintenrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rondroid.explicitintenrecyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler_view.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSend.setOnClickListener {

            binding.buttonSend.setOnClickListener {

                val countryList = ArrayList<CountryData>()
                val country = edTvCountry.text.toString().trim()
                val capital = edTvCapital.text.toString().trim()

                if (country.isNotEmpty() && capital.isNotEmpty()) {
                    val country = CountryData(country, capital)
                    countryList.add(country)
                    my.notifyItemInserted(dataList.size - 1)
                    edTvCountry.text?.clear()
                    edTvCapital.text?.clear()

                    // Directly navigate to RecyclerViewActivity after adding user data
                    val intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
                    intent.putParcelableArrayListExtra("countryList", ArrayList(countryList))
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, "Please enter both name and age", Toast.LENGTH_SHORT).show()
                }

            }

//            val intent = Intent(applicationContext, RecyclerViewActivity::class.java)
//            startActivity(intent)

        }
    }

}