package com.example.shopnotes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopnotes.adapters.ListAdapter
import com.example.shopnotes.ui.theme.ShopNotesTheme

class ListActivity : ComponentActivity() {

    lateinit var notes : MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val bundle = intent.extras
        val listName = bundle!!.getString("listName") ?: "Untitled"

        val sp = getSharedPreferences("ShopNotes", Context.MODE_PRIVATE)
        notes = sp.getStringSet(listName, setOf<String>())?.toMutableList() ?: mutableListOf()

        val addButton = findViewById<Button>(R.id.buttonAdd)

        val recycleList = findViewById<RecyclerView>(R.id.notesList)
        recycleList.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(notes, listName)
        recycleList.adapter = listAdapter

        addButton.setOnClickListener(View.OnClickListener {
            notes.add("")
            listAdapter.notifyDataSetChanged()

        })
    }
}

