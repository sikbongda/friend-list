package com.studyfork.sfoide.api

import com.studyfork.sfoide.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendApiService {
    // https://randomuser.me/api/?page=3&results=10&seed=abc
    @GET("/api/")
    fun getFriendList(
        @Query("page") page: Int,
        @Query("results") result: Int,
        @Query("seed") seed: String
    ): Call<ApiResponse>
}