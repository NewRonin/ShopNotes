package com.example.shopnotes.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopnotes.ListActivity
import com.example.shopnotes.R

class ListsAdapter (val lists : List<String>): RecyclerView.Adapter<ListsAdapter.MyViewHolder>() {

    class MyViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val listName = item.findViewById<TextView>(R.id.listName)
        val imageButton = item.findViewById<ImageButton>(R.id.listImage)

        init {
            imageButton.setOnClickListener(View.OnClickListener {
                val intent = Intent(item.context, ListActivity::class.java)
                val bundle = Bundle()
                bundle.putString("listName", listName.text.toString())
                intent.putExtras(bundle)

                item.context.startActivity(intent)
            })
        }
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