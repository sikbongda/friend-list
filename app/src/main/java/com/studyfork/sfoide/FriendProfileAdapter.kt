package com.studyfork.sfoide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.studyfork.sfoide.model.FriendProfile
import kotlinx.android.synthetic.main.friend_profile_item_view.view.*

class FriendProfileAdapter(
    private val friendList: ArrayList<FriendProfile>,
    private val context: Context
) : RecyclerView.Adapter<FriendProfileAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.name
        val age: TextView = view.age
        val email: TextView = view.email
        val phoneNumber: TextView = view.phone_number
        val cellphoneNumber: TextView = view.cell_phone_number
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.friend_profile_item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = friendList[position].name
        holder.age.text = friendList[position].age.toString()
        holder.email.text = friendList[position].email
        holder.phoneNumber.text = friendList[position].phoneNumber
        holder.cellphoneNumber.text = friendList[position].cellPhoneNumber
    }

}