package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_alert_dialog)
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Keluar dari Aplikasi")
            builder.setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
            builder.setPositiveButton("Ya") { dialog, which ->
                // Implementasi logika ketika pengguna mengklik "Ya" untuk keluar
                finishAffinity() // Mengakhiri semua aktivitas dan keluar dari aplikasi
            }
            builder.setNegativeButton("Tidak") { dialog, which ->
                // Implementasi logika ketika pengguna mengklik "Tidak"
                dialog.dismiss() // Menutup dialog tanpa melakukan apa-apa
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        loadFragment(FHome())

        var bottomnvamenu = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomnvamenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bot_menu_home ->{
                    loadFragment(FHome())
                    true
                }
                R.id.bot_menu_calcu ->{
                    loadFragment(FCalculator())
                    true
                }
                R.id.bot_menu_bmi ->{
                    loadFragment(FBmi())
                    true
                }
                R.id.bot_menu_money ->{
                    loadFragment(FMoney())
                    true
                }
                R.id.bot_menu_profile ->{
                    loadFragment(FProfile())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    }
