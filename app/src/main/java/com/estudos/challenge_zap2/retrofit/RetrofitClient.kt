package com.estudos.challenge_zap2.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    companion object {

        private lateinit var  retrofit: Retrofit
        private val baseUrl = "http://grupozap-code-challenge.s3-website-us-east-1.amazonaws.com/"


        private fun getRetrofitInstance(): Retrofit {

            val httpClient = OkHttpClient.Builder()

            if(!Companion::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
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