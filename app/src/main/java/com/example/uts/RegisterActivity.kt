package com.example.uts

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class RegisterActivity : AppCompatActivity() {
    private var register : ImageView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        register = findViewById(R.id.btn_regis)
        register!!.setOnClickListener{ openMenuLogin() }
    }

    private fun openMenuLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}