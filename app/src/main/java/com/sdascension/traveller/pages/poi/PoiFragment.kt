package com.sdascension.traveller.pages.poi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdascension.traveller.ApiService
import com.sdascension.traveller.R
import com.sdascension.traveller.databinding.FragmentPoiBinding
import com.sdascension.traveller.pages.info.InfoFragment
import kotlinx.android.synthetic.main.fragment_poi.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PoiFragment : Fragment() {

    private lateinit var poiViewModel: PoiViewModel
    private var _binding: FragmentPoiBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflater for the layout
        val view = inflater.inflate(R.layout.fragment_poi, container, false)

        // Use of retrofit library for the api response
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.npoint.io/45928b7adcaec7eb82fa/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)
        api.fetchAllPoi().enqueue(object : Callback<List<Poi>> {
            override fun onResponse(call: Call<List<Poi>>, response: Response<List<Poi>>) {
                if (response.isSuccessful) {
                    // Function to manage the adapter and the layout
                    fun showData(poi: List<Poi>) {
                        view.recyclerView.apply {
                            layoutManager = LinearLayoutManager(activity)
                            adapter = PoiAdapter(poi) { poi -> poiOnClick(poi) }
                        }
                    }
                    showData(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Poi>>, t: Throwable) {
                d("kevin", "onFailure")
            }
        })
        poiViewModel =
            ViewModelProvider(this)[PoiViewModel::
            class.java]
        _binding = FragmentPoiBinding.inflate(inflater, container, false)
        return view
    }

    // Function for the click in each poi
    private fun poiOnClick(poi: Poi?) {
        Log.d(TAG, "Click on: $poi")
        poi?.let {
            navigateToInfo(it)
        }
    }

    // Function to intent and navigate to Info
    private fun navigateToInfo(poi: Poi) {
        val intent = Intent(activity, InfoFragment::class.java).apply {
            putExtra(KEY_TITLE, poi.title)
            putExtra(KEY_DESCRIPTION, poi.description)
            putExtra(KEY_PUNCTUATION, poi.punctuation)
            putExtra(KEY_POI, poi)
        }

        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val TAG = PoiFragment::class.java.simpleName
        const val KEY_TITLE = "poi_extra_title"
        const val KEY_DESCRIPTION = "poi_extra_description"
        const val KEY_PUNCTUATION = "poi_extra_punctuation"
        const val KEY_POI = "poi_extra"
    }
}


