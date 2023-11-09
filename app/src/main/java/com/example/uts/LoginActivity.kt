package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private var login : ImageView? = null
    private var register : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login = findViewById(R.id.btn_log)
        login!!.setOnClickListener { openMenuHome() }
        register = findViewById(R.id.btn_reg)
        register!!.setOnClickListener { openMenuRegister() }
    }
    private fun openMenuHome(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun openMenuRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}