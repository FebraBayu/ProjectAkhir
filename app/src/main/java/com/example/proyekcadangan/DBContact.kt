package com.example.proyekcadangan

import android.provider.BaseColumns

class DBContact {

    class  Soal: BaseColumns {
        companion object{
            val TABLE_NAME="Soal"
            val KOLOM_ID="ID"
            val KOLOM_KATEGORI="KATEGORI"
            val KOLOM_SOAL="SOAL"
            val KOLOM_JAWABAN="JAWABAN"
            val KOLOM_PILIHAN1="PILIHAN1"
            val KOLOM_PILIHAN2="PILIHAN2"
            val KOLOM_PILIHAN3="PILIHAN3"
            val KOLOM_PILIHAN4="PILIHAN4"
            val KOLOM_PILIHAN5="PILIHAN5"

        }
    }
}