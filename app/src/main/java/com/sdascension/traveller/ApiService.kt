package com.sdascension.traveller

import com.sdascension.traveller.pages.poi.Poi
import retrofit2.Call
import retrofit2.http.GET

// Interface to fetch and get the data from the API
interface ApiService {
    @GET("poi")
    fun fetchAllPoi(): Call<List<Poi>>
}