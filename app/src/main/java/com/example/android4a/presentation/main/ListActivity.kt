package com.example.android4a.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.domain.entity.NierCharacter
import com.example.android4a.presentation.status.*
import org.koin.android.ext.android.inject

class ListActivity: AppCompatActivity() {
    private val listViewModel : ListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listViewModel.makeAPICall()
        listViewModel.apiLiveData.observe(this, Observer { it ->
            when(it){
                is APICallSuccess -> {
                    showList(it.charaList)
                }
                APICallFailure -> {
                    Toast.makeText(this, "API Failure", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun showList(characters: List<NierCharacter>){
        val recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val myAdapter = ListAdapter(characters)
        print(myAdapter.itemCount)
        recyclerView.adapter = myAdapter
    }
}