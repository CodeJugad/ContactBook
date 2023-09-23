package com.example.contactbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerAdapter(var context: Context, private val dataList: ArrayList<EntityContact>) : RecyclerView.Adapter<MainRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(var view: View): RecyclerView.ViewHolder(view) {
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainRecyclerAdapter.MyViewHolder {
       var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MainRecyclerAdapter.MyViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txt_name).text = dataList[position].name
        holder.view.findViewById<TextView>(R.id.txt_number).text = dataList[position].number
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}