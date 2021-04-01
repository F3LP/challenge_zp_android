package com.estudos.challenge_zap2.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudos.challenge_zap2.RealEstateRepositoryImpl
import com.estudos.challenge_zap2.databinding.ListRealestateBinding
import com.estudos.challenge_zap2.ui.adapter.RealEstateAdapter
import com.estudos.challenge_zap2.viewmodel.RealEstateViewModel

class ListRealEstateActivity : AppCompatActivity() {

    lateinit var binding: ListRealestateBinding
    private  val viewModel = RealEstateViewModel(RealEstateRepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListRealestateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerListRealestate.layoutManager = LinearLayoutManager(this)
        binding.recyclerListRealestate.adapter = RealEstateAdapter()

        viewModel.getRealEstate().observe(this, Observer{ result ->
            result?.let {
                (binding.recyclerListRealestate.adapter as RealEstateAdapter).updateRealState(it)
            }
            binding.progress.visibility = View.GONE
        })

        binding.recyclerListRealestate
    }
}
