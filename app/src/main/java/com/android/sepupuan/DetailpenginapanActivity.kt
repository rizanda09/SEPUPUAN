package com.android.sepupuan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailpenginapanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailpenginapan)

        val detail = intent.getParcelableExtra<Penginapan>(PenginapanActivity.INTENT_PARCELABLE)

        val gambar = findViewById<ImageView>(R.id._gambarPenginapan)
        val nama = findViewById<TextView>(R.id._namaPenginapan)
        val alamat = findViewById<TextView>(R.id._alamatPenginapan)
        val harga = findViewById<TextView>(R.id._hargaPenginapan)

        detail?.let { gambar.setImageResource(it.penginapanSrc) }
        if (detail != null) {
            nama.text = detail.penginapanNama
        }
        if (detail != null) {
            alamat.text = detail.penginapanAlamat
        }
        if (detail != null) {
            harga.text = detail.penginapanHarga
        }
    }
}