package com.android.sepupuan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kuliner(
    val gambarSrc : Int,
    val gambarNama: String,
    val gambarAlamat : String,
    val gambarHarga : String
): Parcelable
