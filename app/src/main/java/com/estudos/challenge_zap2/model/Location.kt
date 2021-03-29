package com.estudos.challenge_zap.model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)