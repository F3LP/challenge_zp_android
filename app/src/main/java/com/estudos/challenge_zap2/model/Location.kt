package com.estudos.challenge_zap.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
): Parcelable