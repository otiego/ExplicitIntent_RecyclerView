package com.rondroid.explicitintenrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rondroid.explicitintenrecyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val countryList = ArrayList<CountryData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSend.setOnClickListener {

                val country = edTvCountry.text.toString().trim()
                val capital = edTvCapital.text.toString().trim()

                if (country.isNotEmpty() && capital.isNotEmpty()) {
                    val country = CountryData(country, capital)
                    countryList.add(country)
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