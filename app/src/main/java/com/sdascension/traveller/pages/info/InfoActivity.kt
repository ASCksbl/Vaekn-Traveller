package com.sdascension.traveller.pages.info

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sdascension.traveller.R
import com.sdascension.traveller.pages.poi.PoiMapActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_info.*


class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        // Display a back button in the top of the activity
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Intent all the information from poi to info
        val intent = intent
        val title = intent.getStringExtra("title")
        val completedesc = intent.getStringExtra("completedesc")
        val punctuation = intent.getStringExtra("punctuation")
        val image = intent.getStringExtra("image")

        // Set all the information passed into the information activity
        infoTitle.text = title
        infoDescription.text = completedesc
        infoPunctuation.text = punctuation
        Picasso.get()
            .load(image)
            .into(imgInfo)
    }

    // Function for intent to map activity
    fun onLocateInfo(view: View) {
        val intent = intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)
        val intent2 = Intent(this@InfoActivity, PoiMapActivity::class.java)
        intent2.putExtra("title", title)
        intent2.putExtra("description", description)
        intent2.putExtra("latitude", latitude)
        intent2.putExtra("longitude", longitude)
        startActivity(intent2)
    }

    // Function to go back to previous fragment when back is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
