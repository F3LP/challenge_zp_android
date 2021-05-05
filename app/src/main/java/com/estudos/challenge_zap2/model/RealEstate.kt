package com.estudos.challenge_zap.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RealEstate(
    @SerializedName("address")
    val address: Address,
    @SerializedName("bathrooms")
    val bathrooms: Int,
    @SerializedName("bedrooms")
    val bedrooms: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("listingStatus")
    val listingStatus: String,
    @SerializedName("listingType")
    val listingType: String,
    @SerializedName("owner")
    val owner: Boolean,
    @SerializedName("parkingSpaces")
    val parkingSpaces: Int,
    @SerializedName("pricingInfos")
    val pricingInfos: PricingInfos,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("usableAreas")
    val usableAreas: Int
): Parcelable