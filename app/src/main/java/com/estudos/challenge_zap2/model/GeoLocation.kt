package com.estudos.challenge_zap.model


import com.google.gson.annotations.SerializedName

data class GeoLocation(
    @SerializedName("location")
    val location: Location,
    @SerializedName("precision")
    val precision: String
)