package com.victor.victorosaikhuwuomwan_comp304_lab4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.victor.victorosaikhuwuomwan_comp304_lab4.databinding.ActivityLandmarkDetailBinding

class LandmarkDetailActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityLandmarkDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandmarkDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Get landmark data from intent
        val name = intent.getStringExtra("LANDMARK_NAME")
        val address = intent.getStringExtra("LANDMARK_ADDRESS")
        val latitude = intent.getDoubleExtra("LANDMARK_LATITUDE", 0.0)
        val longitude = intent.getDoubleExtra("LANDMARK_LONGITUDE", 0.0)
        val latLng = LatLng(latitude, longitude)

        // Add a marker for the selected landmark and move the camera
        mMap.addMarker(MarkerOptions().position(latLng).title(name).snippet(address))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
