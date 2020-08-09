package com.studyfork.sfoide

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.studyfork.sfoide.api.GlideApp

class FriendDetailActivity : AppCompatActivity() {
    companion object {
        val PHOTO = "PHOTO"
        val NAME = "NAME"
        val AGE = "AGE"
        val EMAIL = "EMAIL"
        val PHONE = "PHONE"
        val CELLPHONE = "CELLPHONE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_detail)

        val name: TextView = findViewById(R.id.name)
        val age: TextView = findViewById(R.id.age)
        val email: TextView = findViewById(R.id.email)
        val phone: TextView = findViewById(R.id.phone_number)
        val cellphone: TextView = findViewById(R.id.cell_phone_number)
        val photo: ImageView = findViewById(R.id.imageView)

        name.text = intent.getStringExtra(NAME)
        age.text = intent.getStringExtra(AGE)
        email.text = intent.getStringExtra(EMAIL)
        phone.text = intent.getStringExtra(PHONE)
        cellphone.text = intent.getStringExtra(CELLPHONE)

        GlideApp.with(this)
            .load(intent.getStringExtra(PHOTO))
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(photo)
    }
}