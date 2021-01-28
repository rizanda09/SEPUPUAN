package com.android.sepupuan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KulinerActivity : AppCompatActivity() {

    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuliner)

        val imageList = listOf<Kuliner>(
                Kuliner(
                        R.drawable.anyangayam,
                        "Anyang",
                        "Jalan Gn. Tua - Padang Sidempuan, Tobat, Padang Bolak, Kabupaten Padang Lawas Utara, Sumatera Utara 22753",
                        "Rp. 4.000 - Rp 7.000"
                ),
                Kuliner(
                        R.drawable.ikanholat,
                        "Holat",
                        "Gn. Hasahatan, Padangsidimpuan Batunadua, Kota Padang Sidempuan, Sumatera Utara 22733",
                        "Rp. 18.000 - Rp 25.000"
                ),
                Kuliner(
                        R.drawable.asampedas,
                        "Ikan Asam Pedas",
                        "Jalan Trans Sumatera Bukittinggi - Padang Sidempuan No.179, Salambue, Padangsidimpuan Tenggara, Kota Padang Sidempuan, Sumatera Utara 22733",
                        "Rp. 60.000"
                ),
                Kuliner(
                        R.drawable.ikanleleasap,
                        "Ikan Sale",
                        "Jalan H. Agus Salim No.64, Wek III, Padangsidimpuan Utara, Kota Padang Sidempuan, Sumatera Utara 22711",
                        "Rp. 15.000 - 20.000"
                ),
                Kuliner(
                        R.drawable.pakkat,
                        "Pakkat",
                        "-",
                        "Rp. 5.000 - Rp 10.000"
                ),
                Kuliner(
                        R.drawable.saterajawali,
                        "Sate Rajawali Nauli",
                        "Jalan Patrice Lumumba No.26a, Wek III, Padangsidimpuan Utara, Kota Padang Sidempuan, Sumatera Utara 22719",
                        "Rp. 14.000"
                ),
                Kuliner(
                        R.drawable.tumisbungapepaya,
                        "Tumis Bunga Pepaya",
                        "Jalan Sunggal No.14, Sei Sikambing B, Kec. Medan Sunggal, Kota Medan, Sumatera Utara 20118",
                        "Rp. 20.000"
                )
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = KulinerAdapter(this, imageList){
            val intent = Intent(this, DetailkulinerActivity::class.java)
            intent.putExtra(KulinerActivity.INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}