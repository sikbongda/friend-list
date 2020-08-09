package com.studyfork.sfoide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.studyfork.sfoide.model.FriendProfile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val dataArray: ArrayList<FriendProfile> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addDataArray()

        friend_recycler_view.layoutManager = LinearLayoutManager(this)
        friend_recycler_view.adapter = FriendProfileAdapter(dataArray, this)
    }

    private fun addDataArray() {
        //TODO: remove later
        var friend: FriendProfile
        for (x in 1..10) {
            friend = FriendProfile("Lucia Brown", 34,
                "F", "es",
                "lucia@example.com",
                "555-111-1111","080-0999-0000","")
            dataArray.add(friend)
        }
    }
}