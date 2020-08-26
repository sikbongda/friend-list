package com.studyfork.sfoide

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.studyfork.sfoide.api.GlideApp
import kotlinx.android.synthetic.main.activity_friend_detail.*

class FriendDetailActivity : AppCompatActivity() {
    companion object {
        const val PHOTO = "PHOTO"
        const val NAME = "NAME"
        const val AGE = "AGE"
        const val EMAIL = "EMAIL"
        const val PHONE = "PHONE"
        const val CELLPHONE = "CELLPHONE"
        const val LATITUDE = "LATITUDE"
        const val LONGITUDE = "LONGITUDE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_detail)

        name.text = intent.getStringExtra(NAME)
        age.text = intent.getStringExtra(AGE)
        email.text = intent.getStringExtra(EMAIL)
        phone_number.text = intent.getStringExtra(PHONE)
        cell_phone_number.text = intent.getStringExtra(CELLPHONE)
        latitude.text = intent.getFloatExtra(LATITUDE, 0f).toString()
        longitude.text = intent.getFloatExtra(LONGITUDE, 0f).toString()

        GlideApp.with(this)
            .load(intent.getStringExtra(PHOTO))
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(photo)
    }
}