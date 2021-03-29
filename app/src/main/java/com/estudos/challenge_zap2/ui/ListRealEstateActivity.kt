package com.estudos.challenge_zap2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.RealEstateAdapter
import com.estudos.challenge_zap2.databinding.ListRealestateBinding
import com.estudos.challenge_zap2.retrofit.RealEstateService
import com.estudos.challenge_zap2.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListRealEstateActivity : AppCompatActivity() {

    lateinit var binding: ListRealestateBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListRealestateBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this).get(RealEstateViewModel::class.java)
//
        println("##################")
//        println(viewModel)

        binding.recyclerListWeather.layoutManager = LinearLayoutManager(this)
        binding.recyclerListWeather.adapter = RealEstateAdapter()

//        val response = RealEstateRepositoryImpl().listRealEstate()
//
//        println(response)

        //--------------

        var service: RealEstateService =
            RetrofitClient.createService(RealEstateService::class.java)
        val call: Call<List<RealEstate>> = service.listRealEstate()

        var response = call.enqueue(object : Callback<List<RealEstate>> {
            override fun onResponse(
                call: Call<List<RealEstate>>,
                response: Response<List<RealEstate>>
            ) {
                val s = response.body()
            }

            override fun onFailure(call: Call<List<RealEstate>>, t: Throwable) {
                val s = t.message

            }
        })


        //--------------

    }

}