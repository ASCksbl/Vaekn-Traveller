package com.sdascension.traveller.pages.info

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// TODO: Still not in use (Not working)
@Parcelize
data class Info(
    val title: String,
    val description: String,
    val image: String,
    val punctuation: String,
    val coordinates: String
) : Parcelable
