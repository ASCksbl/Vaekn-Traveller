package com.sdascension.traveller.pages.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Info(
    val title: String,
    val description: String,
    val image: String,
    val punctuation: String,
    val coordinates: String
) : Parcelable
