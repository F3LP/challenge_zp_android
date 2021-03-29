package com.estudos.challenge_zap2

import androidx.lifecycle.MutableLiveData
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.retrofit.RealEstateService
import com.estudos.challenge_zap2.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RealEstateRepositoryImpl {

    var service: RealEstateService = RetrofitClient.createService(RealEstateService::class.java)
    val call: Call<List<RealEstate>> = service.listRealEstate()

    fun getAllRealEstate(): MutableLiveData<List<RealEstate>?> {
        var liveData = MutableLiveData<List<RealEstate>?>()
        var response = call.enqueue(object : Callback<List<RealEstate>> {
            override fun onResponse(
                call: Call<List<RealEstate>>,
                response: Response<List<RealEstate>>
            ) {
                //retorna json
                println("******************  " + response.body())

                //retorna Unit
                println("******************  " + liveData.postValue(response.body()))
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<RealEstate>>, t: Throwable) {
                val s = t.message
                liveData.postValue(null)
            }
        })
        return liveData
    }

}


