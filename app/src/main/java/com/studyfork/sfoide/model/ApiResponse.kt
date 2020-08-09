package com.studyfork.sfoide.model

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    val results: List<FriendProfile>,
    val info: ResponseInfo
)