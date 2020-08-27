package com.studyfork.sfoide

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.studyfork.sfoide.model.FriendProfile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private val TAG: String? = MainActivity::class.simpleName
    private val viewModel: FriendProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe_layout.setOnRefreshListener(this)

        viewModel.getFriendList(1, 10, "abc")
            .observe(this, androidx.lifecycle.Observer {
                Log.d(TAG, "update UI")
                friend_recycler_view.adapter = FriendProfileAdapter(it, ::onClickItem)
            })

        viewModel.isLoading()
            .observe(this, androidx.lifecycle.Observer {
                swipe_layout.isRefreshing = it
            })
    }

    override fun onRefresh() {
        viewModel.getFriendList(1, 10, "abcd")
            .observe(this, androidx.lifecycle.Observer {
                Log.d(TAG, "onRefresh")
                friend_recycler_view.adapter?.notifyDataSetChanged()
            })
    }

    private fun onClickItem(friend: FriendProfile) {
        val intent = Intent(this, FriendDetailActivity::class.java)
        intent.putExtra(FriendDetailActivity.FRIEND, friend)
        startActivity(intent)
    }
}