package com.example.shopnotes

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

    var notes : MutableList<String> = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list);
        val addButton = findViewById<Button>(R.id.buttonAdd)

        val recycleList = findViewById<RecyclerView>(R.id.notesList)
        recycleList.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(notes)
        recycleList.adapter = listAdapter

        addButton.setOnClickListener(View.OnClickListener {
            notes.add("")
            listAdapter.notifyDataSetChanged()

        })
    }
}

