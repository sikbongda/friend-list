package com.studyfork.sfoide

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.studyfork.sfoide.api.GlideApp
import com.studyfork.sfoide.model.FriendProfile
import kotlinx.android.synthetic.main.friend_profile_item_view.view.*

class FriendProfileAdapter(
    private val friendList: List<FriendProfile>,
    private val context: Context
) : RecyclerView.Adapter<FriendProfileAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.name
        val age: TextView = view.age
        val email: TextView = view.email
        val phoneNumber: TextView = view.phone_number
        val cellphoneNumber: TextView = view.cell_phone_number
        val photo: ImageView = view.photo
    }

    interface OnItemClickListener {
        fun onClick() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.friend_profile_item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = friendList[position].name.first.plus(friendList[position].name.last)
        holder.age.text = friendList[position].dob.age.toString()
        holder.email.text = friendList[position].email
        holder.phoneNumber.text = friendList[position].phoneNumber
        holder.cellphoneNumber.text = friendList[position].cellPhoneNumber

        GlideApp.with(holder.itemView.context)
            .load(friendList[position].photoUrl.large)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, FriendDetailActivity::class.java)
            intent.putExtra(FriendDetailActivity.NAME, friendList[position].name.first.plus(friendList[position].name.last))
            intent.putExtra(FriendDetailActivity.AGE, friendList[position].dob.age.toString())
            intent.putExtra(FriendDetailActivity.EMAIL, friendList[position].email)
            intent.putExtra(FriendDetailActivity.PHONE, friendList[position].phoneNumber)
            intent.putExtra(FriendDetailActivity.CELLPHONE, friendList[position].cellPhoneNumber)
            intent.putExtra(FriendDetailActivity.PHOTO, friendList[position].photoUrl.large)
            context.startActivity(intent)
        }
    }

}