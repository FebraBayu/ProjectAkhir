package com.example.proyekcadangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_materi.*

class Materi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        supportActionBar?.hide()

        btnBab1.setOnClickListener({
            val intent: Intent = Intent(applicationContext, MateriBab1::class.java)
            startActivity(intent)
                })

        btnBab2.setOnClickListener({
            val intent: Intent = Intent(applicationContext, MateriBab2Activity::class.java)
            startActivity(intent)
        })

        btnBab3.setOnClickListener({
            val intent: Intent = Intent(applicationContext, MateriBab3::class.java)
            startActivity(intent)
        })

        btnBab4.setOnClickListener({
            val intent: Intent = Intent(applicationContext, MateriBab4::class.java)
            startActivity(intent)
        })

        }
}