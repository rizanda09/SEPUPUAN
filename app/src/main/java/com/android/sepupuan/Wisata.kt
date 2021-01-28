package com.android.sepupuan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wisata(
    val gambarSrc : Int,
    val gambarNama: String,
    val gambarDeskripsi : String,
    val gambarAlamat : String
): Parcelable
