package com.android.sepupuan

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //firebase auth
        auth = FirebaseAuth.getInstance()
        buttonRegister.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if(email.isEmpty()){
                etEmail.error = "Email harus diisi"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                etEmail.error = "Email tidak valid"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty() || password.length < 8){
                etPassword.error = "Password tidak boleh kurang dari 8 karakter"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            registerUser(email,password)
            Toast.makeText(this,"Daftar Berhasil!",Toast.LENGTH_SHORT).show()
        }


        //menyembunyikan action bar
        supportActionBar?.hide()

        //textview login
        val tvClick = findViewById<TextView>(R.id.textViewLogin)
        tvClick.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        Intent(this@RegisterActivity,LoginActivity::class.java).also {
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }
                    }else
                    {
                        Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
    }
}

