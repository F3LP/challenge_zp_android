package com.estudos.challenge_zap2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estudos.challenge_zap2.RealEstateRepositoryImpl
import com.estudos.challenge_zap2.databinding.ActivityMainBinding
import com.estudos.challenge_zap2.viewmodel.RealEstateViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RealEstateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = RealEstateRepositoryImpl()
        repository.getAllRealEstate()

       println("################################## + ${repository.getAllRealEstate()}")


        binding.buttonVivaReal.setOnClickListener { filterVivaReal() }

    }

    private fun filterVivaReal() {
        val intent = Intent(this, ListRealEstateActivity::class.java)
        startActivity(intent)
    }
}