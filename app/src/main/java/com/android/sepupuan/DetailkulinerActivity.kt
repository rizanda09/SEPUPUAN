package com.android.sepupuan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailkulinerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailkuliner)

        val detail = intent.getParcelableExtra<Kuliner>(KulinerActivity.INTENT_PARCELABLE)
        val gambar = findViewById<ImageView>(R.id._gambarKuliner)
        val nama = findViewById<TextView>(R.id._namaKuliner)
        val alamat = findViewById<TextView>(R.id._alamatKuliner)
        val harga = findViewById<TextView>(R.id._hargaKuliner)

        detail?.let { gambar.setImageResource(it.gambarSrc) }
        if (detail != null) {
            nama.text = detail.gambarNama
        }
        if (detail != null) {
            alamat.text = detail.gambarAlamat
        }
        if (detail != null) {
            harga.text = detail.gambarHarga
        }
    }
}
