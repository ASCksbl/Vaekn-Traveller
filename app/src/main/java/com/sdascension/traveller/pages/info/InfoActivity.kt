package com.sdascension.traveller.pages.info

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sdascension.traveller.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        // Display a back button in the top of the activity
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // TODO: Addition (Not in use)
//        val title = intent.getStringExtra(PoiFragment.KEY_TITLE)
//        val description = intent.getStringExtra(PoiFragment.KEY_DESCRIPTION)
//        val punctuation = intent.getStringExtra(PoiFragment.KEY_PUNCTUATION)
//        val image = intent.getStringExtra(PoiFragment.KEY_IMAGE)
//        val poi = intent.getParcelableExtra<Info>(PoiFragment.KEY_POI)

        // Intent all the information from poi to info
        var intent = intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val punctuation = intent.getStringExtra("punctuation")
        val image = intent.getStringExtra("image")

        // Set all the information passed into the information activity
        infoTitle.text = title
        infoDescription.text = description
        infoPunctuation.text = punctuation
        Picasso.get()
            .load(image)
            .into(imgInfo)
    }


    // Function to go back to previous fragment when back is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private val TAG = InfoActivity::class.java.simpleName
    }

}
