package com.estudos.challenge_zap.model


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("geoLocation")
    val geoLocation: GeoLocation,
    @SerializedName("neighborhood")
    val neighborhood: String
)