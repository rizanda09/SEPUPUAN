package com.android.sepupuan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class WisataActivity : AppCompatActivity() {

    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata)

        val imageList = listOf<Wisata>(
                Wisata(
                        R.drawable.aeksijorni,
                        "Aek Sijorni",
                        "Aek Sijorni adalah tempat wisata alam yang berada di Kelurahan Sayur Matinggi, Tapanuli Selatan Sumatra Utara, lebih kurang 30 km dari kota Padang Sidempuan ke arah Mandailing Natal.",
                        "Jalan Trans Sumatera Bukittinggi - Padang Sidempuan, Aek Libung, Sayur Matinggi, Kabupaten Tapanuli Selatan, Sumatera Utara 22774"
                ),
                Wisata(
                        R.drawable.silimalima,
                        "Air terjun silima lima",
                        "Air terjun Silima-Lima ini salah satu Ikon wisata kabupaten Tapanuli selatan, terletak di Desa Simaninggir, Kecamatan Marancar, Kabupaten Tapanuli Selatan (Tapsel), Sumatera Utara.",
                        "Maju Mambe, Marancar, Kabupaten Tapanuli Selatan, Sumatera Utara 22742"
                ),
                Wisata(
                        R.drawable.sibiobio,
                        "Sibio-Bio",
                        "Sibio-Bio adalah nama sebuah desa kecil di dataran tinggi Angkola timur, Tapanuli Selatan. Yang menjadi salah satu destinasi wisata yg kini yg menjadi magnet baru bagi pecinta liburan dengan suasana alam. Juga memiliki view alam yg cukup indah dengan beragam spot-spot foto yg di tata apik demi memanjakan para wisatawan. Tidak hanya itu, Sibio-Bio juga memiliki \"SIBIO-BIO ADVENTURE PARK\" yang memiliki banyak wahana petualangan seperti Flying fox, Motor ATV, Panahan, kolam renang, outbond arena dan banyak lainnya.",
                        "Kecamatan Angkola Timur, Kabupaten Tapanuli Selatan, Sumatera Utara"
                ),
                Wisata(
                        R.drawable.kebunbungabatangbahal,
                        "Kebun Bunga Matahari Batang Bahal",
                        "Bagi Anda yang suka dengan bunga matahari maka datang ke tempat ini sangat pas dan sesuai. Selain bisa menikmati taman yang indah dan luas, Anda juga dapat mengambil spot penting untuk selfie atau membuat video. Bunga matahari yang ada di sini sangat cantik dan terawat dengan baik. Bunganya besar dan memukau.",
                        "Kecamatan Padangsidimpuan Batunadua, Padang Sidempuan, Sumatra Utara"
                ),
                Wisata(
                        R.drawable.danautao,
                        "Danau Tao",
                        "Danau tao adalah danau salah satu dari tempat wisata yang paling banyak dikunjungi di padang lawas. Danau ini menawarkan hamparan bebukitan, rumput yang menghijau dan menguning, dikelilingi pepohonan yang sangat rindang serta ada sebuah danau dengan warna hijau. Danau Tao berada di alam terbuka nan luas yang dipenuhi kekayaan alam yang alami, hijau dan indah. Penduduk sekitar pun mayoritas pengembala, petani dan nelayan.",
                        "Batang Onang Baru, Batang Onang, Padang Lawas Utara, Kabupaten Padang Lawas Utara, Sumatera Utara 22762"
                )
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = WisataAdapter(this, imageList){
            val intent = Intent(this, DetailwisataActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}
