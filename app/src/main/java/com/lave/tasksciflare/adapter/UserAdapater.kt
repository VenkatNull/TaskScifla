package com.lave.tasksciflare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lave.tasksciflare.R
import com.lave.tasksciflare.model.User
import com.lave.tasksciflare.model.UserItem

class UserAdapater (var context : Context, var list : ArrayList<UserItem>) : RecyclerView.Adapter<UserAdapater.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvName = v.findViewById<TextView>(R.id.user_name)
        var tvEmail = v.findViewById<TextView>(R.id.user_email)
        var tvMobile = v.findViewById<TextView>(R.id.user_mobile)
        var tvGenger = v.findViewById<TextView>(R.id.user_gender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = list[position].nameValuePairs.Name
        holder.tvEmail.text = list[position].nameValuePairs.Email
        holder.tvMobile.text = list[position].nameValuePairs.Mobile
        holder.tvGenger.text = list[position].nameValuePairs.Gender

        /*holder.tvName.text = list[position].get(position).nameValuePairs.Name
        holder.tvEmail.text = list[position].get(position).nameValuePairs.Email
        holder.tvMobile.text = list[position].get(position).nameValuePairs.Mobile
        holder.tvGenger.text = list[position].get(position).nameValuePairs.Gender*/
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}