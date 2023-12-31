package com.example.shopnotes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopnotes.adapters.ListAdapter
import com.example.shopnotes.adapters.ListsAdapter

class MainActivity : ComponentActivity() {

    lateinit var lists : MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main);

        val sp = getSharedPreferences("ShopNotes", Context.MODE_PRIVATE)
        lists = sp.getStringSet("Lists", setOf<String>())?.toMutableList() ?: mutableListOf()

        val recycleList = findViewById<RecyclerView>(R.id.notesList)
        recycleList.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListsAdapter(lists)
        recycleList.adapter = listAdapter

        val addButton = findViewById<Button>(R.id.buttonAdd)

        addButton.setOnClickListener(View.OnClickListener {
            val listName = findViewById<EditText>(R.id.newListName).text.toString()
            lists.add(listName)
            val editor = sp.edit()
            editor.putStringSet("Lists", lists.toSet())
            editor.commit()

            val intent = Intent(this, ListActivity::class.java)
            val bundle = Bundle()
            bundle.putString("listName", listName)
            intent.putExtras(bundle)

            startActivity(intent)

        })
    }
}