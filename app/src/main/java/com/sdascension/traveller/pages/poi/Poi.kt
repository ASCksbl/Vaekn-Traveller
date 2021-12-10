package com.sdascension.traveller.pages.poi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Model for the json data
@Parcelize
data class Poi(
    val title: String,
    val description: String,
    val completedesc: String,
    val image: String,
    val punctuation: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable

