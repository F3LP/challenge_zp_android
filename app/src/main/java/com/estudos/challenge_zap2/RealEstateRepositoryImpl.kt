package com.estudos.challenge_zap2

import androidx.lifecycle.MutableLiveData
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.retrofit.RealEstateService
import com.estudos.challenge_zap2.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RealEstateRepositoryImpl {

    fun getAllRealEstate(): MutableLiveData<List<RealEstate>> {
        var listAll = MutableLiveData<List<RealEstate>>()
        var service: RealEstateService = RetrofitClient.createService(RealEstateService::class.java)
        val call: Call<List<RealEstate>> = service.listRealEstate()
        val response = call.enqueue(object : Callback<List<RealEstate>> {
            override fun onResponse(
                call: Call<List<RealEstate>>,
                response: Response<List<RealEstate>>
            ) {
                listAll.value = response.body()
            }

            override fun onFailure(call: Call<List<RealEstate>>, t: Throwable) {
                val s = t.message
            }
        })
        return listAll
    }

//    fun gerRealEstateZap(): MutableLiveData<List<RealEstate>> {
//        var listAll = MutableLiveData<List<RealEstate>>()
//        var service: RealEstateService = RetrofitClient.createService(RealEstateService::class.java)
//        val call: Call<List<RealEstate>> = service.listRealEstate()
//        val response = call.enqueue(object : Callback<List<RealEstate>> {
//            override fun onResponse(
//                call: Call<List<RealEstate>>,
//                response: Response<List<RealEstate>>
//            ) {
//                listAll.value = response.body()
//                //?.filterRentalMinZap(this)
////                    .filterLatLon()
////                    if(it.pricingInfos.businessType == "RENTAL") {
////                        it.pricingInfos.price.toDouble() >= 3500.0
////                    } else{
////                        it.pricingInfos.price.toDouble() >= 600000.0
////                    }
////                    if(it.address.geoLocation.location.lon != 0 && it.address.geoLocation.location.lat != 0){
////
////                    }
//            }
//
//            override fun onFailure(call: Call<List<RealEstate>>, t: Throwable) {
//                val s = t.message
//            }
//        })
//        return listAll
//    }
}
