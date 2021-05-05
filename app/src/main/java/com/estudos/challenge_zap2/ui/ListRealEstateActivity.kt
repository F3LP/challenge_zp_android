package com.estudos.challenge_zap2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.databinding.ListRealestateBinding
import com.estudos.challenge_zap2.ui.adapter.RealEstateAdapter

class ListRealEstateActivity : AppCompatActivity(), RealEstateAdapter.OnItemClickListener {

    lateinit var binding: ListRealestateBinding
    private lateinit var viewModel: RealEstateViewModel
    private lateinit var listRealEstate: MutableList<RealEstate>

    object ServiceLocatorViewModel {
        fun getViewModel() = RealEstateViewModel(RealEstateRepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListRealestateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listRealEstate = mutableListOf()

        binding.recyclerListRealestate.layoutManager = LinearLayoutManager(this)
        binding.recyclerListRealestate.adapter = RealEstateAdapter(listRealEstate, this)

        viewModel = ServiceLocatorViewModel.getViewModel()
        viewModel.getRealEstate()
        viewModel.result.observe(this, { result ->
            result?.let {
                (binding.recyclerListRealestate.adapter as RealEstateAdapter).updateRealState(it)
            }
            binding.progress.isVisible = false
        })
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, ItemRealEstateDetailActivity::class.java)
        intent.putExtra("realEstate", listRealEstate.get(position))
        startActivity(intent)

    }
}
