package com.sdascension.traveller

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

// THIS GOOGLE MAP FRAGMENT IS FOR HOME, TO LOCATE THE CITY SELECTED
class MapFragment : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_map)
        createFragment()
        
        // Display a back button in the top of the activity
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Google Maps Fragment
    private fun createFragment() {
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    // Function to set the map
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }

    // Function to locate and set a marker
    private fun createMarker() {
        val coordinates = LatLng(10.39288811241211, -75.4820300510872)
        map.addMarker(MarkerOptions().position(coordinates).title("Marker is in Cartagena"))
        map.moveCamera(CameraUpdateFactory.newLatLng(coordinates))
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 10f),
            4000, null
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