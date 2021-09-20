package com.example.proyekcadangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_daftar_kuis.*
import kotlinx.android.synthetic.main.activity_main.*

class DaftarKuis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_kuis)
        supportActionBar?.hide()

            Konversi.setOnClickListener({
            val intent : Intent = Intent(applicationContext,Kuis::class.java)
                intent.putExtra("kategori", "Konversi")
                startActivity(intent)
        })

            Aritmatika.setOnClickListener({
            val intent : Intent = Intent(applicationContext,Kuis::class.java)
                intent.putExtra("kategori", "Aritmatika")
                startActivity(intent)
        })

            Komplemen.setOnClickListener({
            val intent : Intent = Intent(applicationContext,Kuis::class.java)
                intent.putExtra("kategori", "Komplemen")
                startActivity(intent)
        })

    }
}