package com.studyfork.sfoide.model

import com.google.gson.annotations.SerializedName

data class Dob(
    val date: String,
    val age: Int
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Location(
    val coordinates: Coordinates
)

data class Coordinates(
    val latitude: Float,
    val longitude: Float
)

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
)