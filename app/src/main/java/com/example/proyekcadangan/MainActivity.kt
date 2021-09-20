package com.example.proyekcadangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        btnMateri.setOnClickListener({
            val intent : Intent = Intent(applicationContext,Materi::class.java)
            startActivity(intent)
        })

        btnSoal.setOnClickListener({
            val intent : Intent = Intent(applicationContext,DaftarKuis::class.java)
            startActivity(intent)
        })

        btnKalkulator.setOnClickListener({
            val intent : Intent = Intent(applicationContext,Kalkulator::class.java)
            startActivity(intent)
        })


    }
}