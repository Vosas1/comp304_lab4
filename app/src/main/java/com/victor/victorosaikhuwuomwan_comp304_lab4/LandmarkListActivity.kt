package com.victor.victorosaikhuwuomwan_comp304_lab4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.model.LatLng

class LandmarkListActivity : AppCompatActivity() {

    private lateinit var recyclerViewLandmarks: RecyclerView
    private lateinit var landmarkAdapter: LandmarkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark_list)

        // Enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerViewLandmarks = findViewById(R.id.recyclerViewLandmarks)
        recyclerViewLandmarks.layoutManager = LinearLayoutManager(this)

        val type = intent.getStringExtra("LANDMARK_TYPE") ?: return
        val landmarks = getLandmarksByType(type)
        landmarkAdapter = LandmarkAdapter(landmarks, this)
        recyclerViewLandmarks.adapter = landmarkAdapter
    }

    private fun getLandmarksByType(type: String): List<Landmark> {
        // Landmark locations
        val allLandmarks = listOf(
            Landmark("Casa Loma", "1 Austin Terrace, Toronto", "Old Buildings", LatLng(43.6780, -79.4094)),
            Landmark("Royal Ontario Museum", "100 Queens Park, Toronto", "Museums", LatLng(43.6677, -79.3948)),
            Landmark("Rogers Centre", "1 Blue Jays Way, Toronto", "Stadiums", LatLng(43.6414, -79.3894)),
            Landmark("CN Tower", "301 Front St W, Toronto", "Attractions", LatLng(43.6426, -79.3871))
        )
        return allLandmarks.filter { it.type == type }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
