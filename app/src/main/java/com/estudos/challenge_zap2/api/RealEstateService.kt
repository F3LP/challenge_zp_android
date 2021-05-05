package com.estudos.challenge_zap2.api

import com.estudos.challenge_zap.model.RealEstate
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RealEstateService {

    @GET("sources/source-1.json")
    fun listRealEstate(): Call<List<RealEstate>>

    //coroutine

    companion object {

        private lateinit var  retrofit: Retrofit
        private val baseUrl = "http://grupozap-code-challenge.s3-website-us-east-1.amazonaws.com/"

        private fun getRetrofitInstance(): Retrofit {

            // service locator

            if(!Companion::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <T> createService(serviceClass: Class<T>): T {
            return getRetrofitInstance().create(serviceClass)
        }
    }

}