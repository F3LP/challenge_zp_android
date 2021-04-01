package com.estudos.challenge_zap2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estudos.challenge_zap2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonVivaReal.setOnClickListener { filterVivaReal() }
        binding.buttonZap.setOnClickListener { filterZap() }

    }

    // métodos provisórios

    private fun filterZap() {
        val intent = Intent(this, ListRealEstateActivity::class.java)
        startActivity(intent)
    }

    private fun filterVivaReal() {
        val intent = Intent(this, ListRealEstateActivity::class.java)
        startActivity(intent)
    }
}