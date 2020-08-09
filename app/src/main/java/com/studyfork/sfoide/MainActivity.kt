package com.studyfork.sfoide

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.studyfork.sfoide.api.ApiBuilder
import com.studyfork.sfoide.api.FriendApiService
import com.studyfork.sfoide.model.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String? = MainActivity::class.simpleName
    var dataArray: List<FriendProfile> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = ApiBuilder().build()
        val friendService = retrofit.create(FriendApiService::class.java)

        val friendPerPage = 10

        friendService.getFriendList(3, friendPerPage, "abc").enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e(TAG, "onFailure ${t.message}")
            }

            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                val res: ApiResponse? = response.body()
                Log.d(TAG, "onResponse body: ${res.toString()}")
                //Log.d(TAG, "result: ${res?.results}")
                //Log.d(TAG, "name: ${res?.results?.get(0)?.name}")
                dataArray = res?.results!!

                friend_recycler_view.layoutManager = LinearLayoutManager(baseContext)
                friend_recycler_view.adapter = FriendProfileAdapter(dataArray, baseContext)
            }
        })


    }
}