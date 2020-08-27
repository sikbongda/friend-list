package com.studyfork.sfoide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studyfork.sfoide.api.GlideApp
import com.studyfork.sfoide.model.FriendProfile
import kotlinx.android.synthetic.main.activity_friend_detail.*

class FriendDetailActivity : AppCompatActivity() {
    companion object {
        const val FRIEND = "FRIEND"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_detail)

        val friend = intent.getParcelableExtra<FriendProfile>(FRIEND)
        friend?.let{
            GlideApp.with(this)
                .load(it.photoUrl.large)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(photo)

            name.text = it.name.first.plus(it.name.last)
            age.text = it.dob.age.toString()
            email.text = it.email
            phone_number.text = it.phoneNumber
            cell_phone_number.text = it.cellPhoneNumber
            latitude.text = it.location.coordinates.latitude.toString()
            longitude.text = it.location.coordinates.longitude.toString()
        }
    }
}