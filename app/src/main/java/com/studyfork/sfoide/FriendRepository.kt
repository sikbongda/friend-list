package com.studyfork.sfoide

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.studyfork.sfoide.api.ApiBuilder
import com.studyfork.sfoide.api.FriendApiService
import com.studyfork.sfoide.model.ApiResponse
import com.studyfork.sfoide.model.FriendProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FriendRepository {
    private val TAG = "FriendRepository"

    private val friendList: MutableLiveData<List<FriendProfile>> = MutableLiveData()
    private val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getFriendList(page: Int, results: Int, seed: String): MutableLiveData<List<FriendProfile>> {
        Log.d(TAG, "getFriendList page=${page} results=${results} seed=${seed}")

        val retrofit = ApiBuilder().build()
        val friendService = retrofit.create(FriendApiService::class.java)

        isLoading.value = true

        friendService.getFriendList(page, results, seed)
            .enqueue(object : Callback<ApiResponse> {
                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                    isLoading.value = false
                }

                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    Log.d(TAG, "onResponse: http code=${response.code()}")

                    if (response.code() == 200) { // 200 OK
                        val res: ApiResponse? = response.body()
                        friendList.value = res?.results
                    }
                    isLoading.value = false
                }
            })

        return friendList
    }

    fun getIsLoading(): MutableLiveData<Boolean> {
        return isLoading
    }
}