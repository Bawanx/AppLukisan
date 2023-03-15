package com.ra.myapp

import android.os.Parcelable
import android.webkit.WebStorage.Origin
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lukisan(
    val name: String,
    val description: String,
    val photo: Int,
    val price: String,
    val origin: String,
) : Parcelable