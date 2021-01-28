package com.android.sepupuan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Penginapan(
        val penginapanSrc : Int,
        val penginapanNama: String,
        val penginapanAlamat : String,
        val penginapanHarga : String
): Parcelable
