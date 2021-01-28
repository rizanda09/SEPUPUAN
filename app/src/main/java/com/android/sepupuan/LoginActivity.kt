package com.android.sepupuan

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        buttonLogin.setOnClickListener{
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
            if(password.isEmpty()){
                etPassword.error = "Password tidak boleh kosong"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            if(password.length < 8){
            etPassword.error = "Password kurang dari 8 karakter"
            etPassword.requestFocus()
            return@setOnClickListener
        }
            loginUser(email,password)
        }

        //menyembunyikan action bar
        supportActionBar?.hide()

        //untuk beralih ke halaman register
        val tvClick = findViewById<TextView>(R.id.textViewSignUp)
        tvClick.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    RegisterActivity::class.java
                )
            )
        }
    }

    //fungsi untuk validasi login
    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        Intent(this@LoginActivity, MainActivity::class.java).also { intent ->
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }
                    }else{
                        Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}