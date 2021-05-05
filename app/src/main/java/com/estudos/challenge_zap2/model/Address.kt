package com.estudos.challenge_zap.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("geoLocation")
    val geoLocation: GeoLocation?,
    @SerializedName("neighborhood")
    val neighborhood: String?
): Parcelable