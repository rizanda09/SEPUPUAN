package com.android.sepupuan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvWisata = findViewById<CardView>(R.id.tempatWisata)
        cvWisata.setOnClickListener { startActivity(Intent(this@MainActivity, WisataActivity::class.java)) }

        val cvKuliner = findViewById<CardView>(R.id.kuliner)
        cvKuliner.setOnClickListener { startActivity(Intent(this@MainActivity, KulinerActivity::class.java)) }

        val cvPenginapan = findViewById<CardView>(R.id.tempatPenginapan)
        cvPenginapan.setOnClickListener { startActivity(Intent(this@MainActivity, PenginapanActivity::class.java)) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.op_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout){
            auth = FirebaseAuth.getInstance()
            auth.signOut()
            Intent(this@MainActivity,LoginActivity::class.java).also{
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        var dialogBuilder = AlertDialog.Builder(this)
                .setMessage("Apakah anda ingin keluar?")
                .setPositiveButton("Ya") {DialogInterface, i ->
                    super.onBackPressed()}
                .setNegativeButton("Tidak") {DialogInterface, i ->
                }
        dialogBuilder.show()
    }
}