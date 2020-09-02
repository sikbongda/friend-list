package com.studyfork.sfoide

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.studyfork.sfoide.model.FriendProfile

class FriendFragmentActivity : AppCompatActivity() {
    companion object {
        const val TAG = "FriendFragmentActivity"
        const val PARAM = "PARAM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ff)

        val friend = intent.getParcelableExtra<FriendProfile>(PARAM)
        val f = FriendDetailFragment()
        f.arguments = bundleOf(Pair("TEST", friend))

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, f)
            .commitAllowingStateLoss()
    }
}