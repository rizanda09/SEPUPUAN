package com.android.sepupuan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PenginapanActivity : AppCompatActivity() {

    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penginapan)

        val imageList = listOf<Penginapan>(

            Penginapan(
                R.drawable.megahotel,
                "Mega Permata Hotel",
                "Jalan Imam Bonjol No.178 Padangsidempuan, Padang Sidempuan Selatan, Padang Sidempuan, Sumatera Utara, Indonesia, 22726",
                "Rp. 400.000 - Rp. 800.000"
            ),
            Penginapan(
                R.drawable.mutiarahotel,
                "Mutiara Hotel Padang Sidempuan",
                "Jalan Imam Bonjol No. 303, Padang Matinggi, Padang Sidempuan Selatan, Padang Sidempuan, Sumatera Utara, Indonesia, 22727",
                "Rp. 543.000 - Rp. 586.000"
            ),
            Penginapan(
                R.drawable.nadinrahouse,
                "Nadinra House",
                "Sitamiang, Padangsidimpuan Sel., Kota Padang Sidempuan, Sumatera Utara 22733",
                "Rp. -"
            ),
            Penginapan(
                R.drawable.natamahotel,
                "Natama Hotel Padang Sidempuan",
                "Jalan Sisingamangaraja No. 100, Padang Sidempuan Selatan, Padang Sidempuan, Sumatera Utara, Indonesia, 22723",
                "Rp. 350.000"
            ),
            Penginapan(
                R.drawable.piahotel,
                "Pia Hotel Padang Sidempuan",
                "Jalan Raja Inal Siregar KM 3,5, Padang Sidempuan Utara, Padang Sidempuan, Sumatera Utara, Indonesia, 22733",
                "Rp. 363.000 - Rp. 484.000"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvPenginapan)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = PenginapanAdapter(this, imageList){
            val intent = Intent(this, DetailpenginapanActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}
