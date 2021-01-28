package com.android.sepupuan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@Splash, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },2750)
    }
}