package com.estudos.challenge_zap2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.databinding.ActivityMainBinding
import com.estudos.challenge_zap2.viewmodel.RealEstateViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RealEstateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = RealEstateRepositoryImpl().getAllRealEstate()

        println("################################## " + repository)


        binding.buttonVivaReal.setOnClickListener { filterVivaReal() }

    }

    private fun filterVivaReal() {
        val intent = Intent(this, ListRealEstateActivity::class.java)
        startActivity(intent)
    }
}