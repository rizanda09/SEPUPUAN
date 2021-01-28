package com.android.sepupuan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailwisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailwisata)

        val detail = intent.getParcelableExtra<Wisata>(WisataActivity.INTENT_PARCELABLE)

        val gambar = findViewById<ImageView>(R.id._gambarWisata)
        val nama = findViewById<TextView>(R.id._namaWisata)
        val deskripsi = findViewById<TextView>(R.id._wisataDesc)
        val lokasi = findViewById<TextView>(R.id._alamatWisata)

        detail?.let { gambar.setImageResource(it.gambarSrc) }
        if (detail != null) {
            nama.text = detail.gambarNama
        }
        if (detail != null) {
            deskripsi.text = detail.gambarDeskripsi
        }
        if (detail != null) {
            lokasi.text = detail.gambarAlamat
        }
    }
}
