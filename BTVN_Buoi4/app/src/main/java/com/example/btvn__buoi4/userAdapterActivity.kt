package com.example.btvn__buoi4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class userAdapterActivity(val userList: MutableList<dataUserActivity>) :
    RecyclerView.Adapter<userAdapterActivity.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewEmail = itemView.findViewById<TextView>(R.id.email_infor)
        val textViewPassword = itemView.findViewById<TextView>(R.id.Password_infor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userAdapterActivity.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_infor, parent, false)
        return UserViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: userAdapterActivity.UserViewHolder, position: Int) {
        holder.textViewEmail.text = userList[position].email
        holder.textViewPassword.text = userList[position].pass
    }


    override fun getItemCount(): Int = userList.size
}