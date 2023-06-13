package com.example.mycrud.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycrud.R
import com.example.mycrud.data.entity.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog) {
        this.dialog = dialog
    }

    interface Dialog {
        fun  onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var fullName: TextView
        var email: TextView
        var phone: TextView
        var nim: TextView
        var alamat: TextView

        init {
            fullName = view.findViewById(R.id.fullname)
            email = view.findViewById(R.id.email)
            phone = view.findViewById(R.id.phone)
            nim = view.findViewById(R.id.nim)
            alamat = view.findViewById(R.id.alamat)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
    return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullName.text = list[position].fullName
        holder.email.text = list[position].email
        holder.phone.text = list[position].phone
        holder.nim.text = list[position].nim
        holder.alamat.text = list[position].alamat

    }
}