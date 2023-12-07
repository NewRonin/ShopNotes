package com.example.shopnotes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopnotes.R

class ListsAdapter (val lists : List<String>): RecyclerView.Adapter<ListsAdapter.MyViewHolder>() {

    class MyViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val listName = item.findViewById<TextView>(R.id.listName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.noteslist_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ListsAdapter.MyViewHolder, position: Int) {
        holder.listName.text = lists[position]
    }

    override fun getItemCount() = lists.size

}