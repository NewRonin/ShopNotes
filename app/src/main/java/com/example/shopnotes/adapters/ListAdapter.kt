package com.example.shopnotes.adapters

import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopnotes.R

class ListAdapter (var list : MutableList<String>, val listName : String): RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    class MyViewHolder(item : View) : RecyclerView.ViewHolder(item){
        var noteName = item.findViewById<EditText>(R.id.noteText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        holder.noteName.setText(list[position])

        if (position == itemCount - 1) {
            holder.noteName.requestFocus()
        }

        holder.noteName.setOnEditorActionListener { v, actionId, event ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    list[position] = v.text.toString()
                    val sp = v.context.getSharedPreferences("ShopNotes", Context.MODE_PRIVATE)
                    val editor = sp.edit()
                    editor.putStringSet(listName, list.toSet())
                    editor.commit()
                    false
                }

                else -> false
            }
        }
    }

    override fun getItemCount() = list.size

}