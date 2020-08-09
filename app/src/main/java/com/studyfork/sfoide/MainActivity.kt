package com.studyfork.sfoide

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG: String? = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        friend_recycler_view.layoutManager = LinearLayoutManager(this)

        val viewModel: FriendProfileViewModel by viewModels()
        viewModel.getFriendList(3, 10, "abc")
            .observe(this, androidx.lifecycle.Observer {
                Log.d(TAG, "update UI");
                friend_recycler_view.adapter = FriendProfileAdapter(it, this)
            })
    }
}