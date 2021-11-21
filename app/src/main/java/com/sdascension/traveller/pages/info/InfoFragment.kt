package com.sdascension.traveller.pages.info

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sdascension.traveller.R
import com.sdascension.traveller.pages.poi.Poi
import com.sdascension.traveller.pages.poi.PoiFragment

// TODO: Change this activity to a fragment
class InfoFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_info)

        Log.d(TAG, "onCreate")
        val title = intent.getStringExtra(PoiFragment.KEY_TITLE)
        val description = intent.getStringExtra(PoiFragment.KEY_DESCRIPTION)
        val punctuation = intent.getStringExtra(PoiFragment.KEY_PUNCTUATION)
        val poi = intent.getParcelableExtra<Poi>(PoiFragment.KEY_POI)

        Log.d(TAG, "Title: $title")
        Log.d(TAG, "Description: $description")
        Log.d(TAG, "Punctuation: $punctuation")
        Log.d(TAG, "Poi: $poi")
    }

    // TODO: Add Functionality to the info fragment

    companion object {
        private val TAG = InfoFragment::class.java.simpleName
    }

}