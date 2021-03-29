package com.estudos.challenge_zap2.retrofit

import com.estudos.challenge_zap.model.RealEstate
import retrofit2.Call
import retrofit2.http.GET

interface RealEstateService {

    @GET("sources/source-1.json")
    fun listRealEstate(): Call<List<RealEstate>>
}