package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.uts.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
   private var login : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        login = findViewById(R.id.btn_mulai)
        login!!.setOnClickListener { openMenuLogin() }
    }
    private fun openMenuLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}