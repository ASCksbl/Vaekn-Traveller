package com.sdascension.traveller.pages.poi

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sdascension.traveller.R
import com.sdascension.traveller.databinding.ActivityPoiMapBinding

class PoiMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityPoiMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val title = intent.getStringExtra("title")
        supportActionBar?.title = title
        binding = ActivityPoiMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    // TODO: Put the correct coordinates in the json
    // Map marker and location for each poi
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)
        val latLng = LatLng(latitude, longitude)
        mMap.addMarker(
            MarkerOptions().position(latLng).title(title).snippet(description)
        )

        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                latLng,
                20f
            ),
            4000,
            null
        )
    }

    // Function to go back to previous fragment or activity when back is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}