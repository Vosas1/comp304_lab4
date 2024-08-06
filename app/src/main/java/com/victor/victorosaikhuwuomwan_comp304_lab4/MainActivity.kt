package com.victor.victorosaikhuwuomwan_comp304_lab4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), LandmarkTypeAdapter.OnItemClickListener {

    private lateinit var recyclerViewLandmarkTypes: RecyclerView
    private lateinit var landmarkTypeAdapter: LandmarkTypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewLandmarkTypes = findViewById(R.id.recyclerViewLandmarkTypes)
        recyclerViewLandmarkTypes.layoutManager = LinearLayoutManager(this)

        val landmarkTypes = listOf("Old Buildings", "Museums", "Stadiums", "Attractions")
        landmarkTypeAdapter = LandmarkTypeAdapter(landmarkTypes, this, this)
        recyclerViewLandmarkTypes.adapter = landmarkTypeAdapter
    }

    override fun onItemClick(type: String) {
        val intent = Intent(this, LandmarkListActivity::class.java)
        intent.putExtra("LANDMARK_TYPE", type)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

