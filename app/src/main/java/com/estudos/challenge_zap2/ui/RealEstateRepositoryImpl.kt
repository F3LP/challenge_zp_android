package com.estudos.challenge_zap2.ui

import androidx.lifecycle.MutableLiveData
import com.estudos.challenge_zap.model.RealEstate
import com.estudos.challenge_zap2.api.RealEstateService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RealEstateRepositoryImpl {

    // data source arquitetua recomendada

    private lateinit var service: RealEstateService

    object ServiceLocator {
        fun getService() = RealEstateService.createService(RealEstateService::class.java)
    }

    fun getAllRealEstate(): MutableLiveData<List<RealEstate>> {
        val listAll = MutableLiveData<List<RealEstate>>()
        service = ServiceLocator.getService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.listRealEstate().execute()
            listAll.postValue(response.body())
        }
        return listAll
    }


//        val call: Call<List<RealEstate>> = service.listRealEstate()
//        call.enqueue(object : Callback<List<RealEstate>> {
//            override fun onResponse(
//                call: Call<List<RealEstate>>,
//                response: Response<List<RealEstate>>
//            ) {
//                    listAll.value = response.body()
//            }
//            override fun onFailure(call: Call<List<RealEstate>>, t: Throwable) {
//                val s = t.message
//            }
//        })


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
