package com.studyfork.sfoide.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dob(
    val date: String,
    val age: Int
) : Parcelable

@Parcelize
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
) : Parcelable

@Parcelize
data class Name(
    val title: String,
    val first: String,
    val last: String
) : Parcelable

@Parcelize
data class Location(
    val coordinates: Coordinates
) : Parcelable

@Parcelize
data class Coordinates(
    val latitude: Float,
    val longitude: Float
) : Parcelable

@Parcelize
data class FriendProfile(
    val name: Name,
    val dob: Dob,
    val gender: String,
    val location: Location,
    @SerializedName("nat") val country: String,
    val email: String,
    @SerializedName("phone") val phoneNumber: String,
    @SerializedName("cell") val cellPhoneNumber: String,
    @SerializedName("picture") val photoUrl: Picture
) : Parcelable