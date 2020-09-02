package com.studyfork.sfoide

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.studyfork.sfoide.model.FriendProfile
import kotlinx.android.synthetic.main.fragment_friend_detail.*

class FriendDetailFragment : Fragment() {
    companion object {
        const val TAG = "FriendDetailFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_friend_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<FriendProfile>("TEST")?.let {
            test_text.text = it.country
        }
    }
}