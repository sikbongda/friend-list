package com.studyfork.sfoide

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
    private val itemClick: (FriendProfile) -> Unit
) : RecyclerView.Adapter<FriendProfileAdapter.FriendViewHolder>() {

    inner class FriendViewHolder(view: View, itemClick: (FriendProfile) -> Unit) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.name
        val age: TextView = view.age
        val email: TextView = view.email
        val phoneNumber: TextView = view.phone_number
        val cellphoneNumber: TextView = view.cell_phone_number
        val photo: ImageView = view.photo

        init {
            view.setOnClickListener { itemClick(friendList[adapterPosition]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.friend_profile_item_view, parent, false), itemClick
        )
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.name.text = friendList[position].name.first.plus(friendList[position].name.last)
        holder.age.text = friendList[position].dob.age.toString()
        holder.email.text = friendList[position].email
        holder.phoneNumber.text = friendList[position].phoneNumber
        holder.cellphoneNumber.text = friendList[position].cellPhoneNumber

        GlideApp.with(holder.itemView.context)
            .load(friendList[position].photoUrl.large)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.photo)
    }

}