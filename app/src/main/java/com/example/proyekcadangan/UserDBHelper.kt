package com.example.proyekcadangan

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class UserDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null){
            db.execSQL((SQL_CREATE_TABLE1))
        }
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_TABLE1)
        onCreate(db)
    }


    fun AddSoal(soal: Soal): Boolean{
        val db = writableDatabase
        val values = ContentValues()
        values.put(DBContact.Soal.KOLOM_ID, soal.id)
        values.put(DBContact.Soal.KOLOM_KATEGORI, soal.kategori)
        values.put(DBContact.Soal.KOLOM_SOAL, soal.soal)
        values.put(DBContact.Soal.KOLOM_JAWABAN, soal.jawaban)
        values.put(DBContact.Soal.KOLOM_PILIHAN1, soal.pilihan1)
        values.put(DBContact.Soal.KOLOM_PILIHAN2, soal.pilihan2)
        values.put(DBContact.Soal.KOLOM_PILIHAN3, soal.pilihan3)
        values.put(DBContact.Soal.KOLOM_PILIHAN4, soal.pilihan4)
        values.put(DBContact.Soal.KOLOM_PILIHAN5, soal.pilihan5)
        val newRow = db.insert(DBContact.Soal.TABLE_NAME,null, values)
        return true
    }

    fun readAllSoal(param: String): ArrayList<Soal>{
        val sooal = ArrayList<Soal>()
        //var param: String = konteks
        val db = readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContact.Soal.TABLE_NAME, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_TABLE1)
            return ArrayList()
        }
        var Aydi: String
        var Kategorii: String
        var Soall: String
        var Jawabann: String
        var Pilihann1: String
        var Pilihann2: String
        var Pilihann3: String
        var Pilihann4: String
        var Pilihann5: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                if (cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_KATEGORI)) == param){
                    Aydi = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_ID))
                    Kategorii = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_KATEGORI))
                    Soall = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_SOAL))
                    Jawabann = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_JAWABAN))
                    Pilihann1 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN1))
                    Pilihann2 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN2))
                    Pilihann3 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN3))
                    Pilihann4 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN4))
                    Pilihann5 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN5))
                    sooal.add(Soal(Aydi, Kategorii, Soall, Jawabann, Pilihann1, Pilihann2, Pilihann3, Pilihann4, Pilihann5))
                }
                cursor.moveToNext()
            }
        }
        return sooal
    }


    fun readAllSoalMain(): ArrayList<Soal>{
        val sooal = ArrayList<Soal>()
        //var param: String = konteks
        val db = readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContact.Soal.TABLE_NAME, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_TABLE1)
            return ArrayList()
        }
        var Aydi: String
        var Kategorii: String
        var Soall: String
        var Jawabann: String
        var Pilihann1: String
        var Pilihann2: String
        var Pilihann3: String
        var Pilihann4: String
        var Pilihann5: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
//                if (cursor.getString(cursor.getColumnIndex(DBContact.Materi.KOLOM_KATEGORI)) == param){
                Aydi = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_ID))
                Kategorii = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_KATEGORI))
                Soall = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_SOAL))
                Jawabann = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_JAWABAN))
                Pilihann1 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN1))
                Pilihann2 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN2))
                Pilihann3 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN3))
                Pilihann4 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN4))
                Pilihann5 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN5))
                sooal.add(Soal(Aydi, Kategorii, Soall, Jawabann, Pilihann1, Pilihann2, Pilihann3, Pilihann4, Pilihann5))
//                }
                cursor.moveToNext()
            }
        }
        return sooal
    }


//    fun readAllSoal(): ArrayList<Soal>{
//        val sooal = ArrayList<Soal>()
//        val db = readableDatabase
//        var cursor: Cursor? = null
//        try {
//            cursor = db.rawQuery("select * from " + DBContact.Soal.TABLE_NAME, null)
//        } catch (e: SQLiteException) {
//            db.execSQL(SQL_CREATE_TABLE1)
//            return ArrayList()
//        }
//        var Aydi: String
//        var Kategorii: String
//        var Soall: String
//        var Jawabann: String
//        var Pilihann1: String
//        var Pilihann2: String
//        var Pilihann3: String
//        var Pilihann4: String
//        var Pilihann5: String
//        if (cursor!!.moveToFirst()) {
//            while (cursor.isAfterLast == false) {
//                //if (cursor.getString(cursor.getColumnIndex(DBContact.Materi.KOLOM_KATEGORI)) == konteks){
//                Aydi = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_ID))
//                Kategorii = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_KATEGORI))
//                Soall = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_SOAL))
//                Jawabann = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_JAWABAN))
//                Pilihann1 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN1))
//                Pilihann2 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN2))
//                Pilihann3 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN3))
//                Pilihann4 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN4))
//                Pilihann5 = cursor.getString(cursor.getColumnIndex(DBContact.Soal.KOLOM_PILIHAN5))
//                sooal.add(Soal(Aydi, Kategorii, Soall, Jawabann, Pilihann1, Pilihann2, Pilihann3, Pilihann4, Pilihann5))
//                //}
//                cursor.moveToNext()
//            }
//        }
//        return sooal
//    }
    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "DB_Proyek.db"

        private  val SQL_CREATE_TABLE1 =
            "CREATE TABLE " + DBContact.Soal.TABLE_NAME + " (" +
                    DBContact.Soal.KOLOM_ID + " TEXT PRIMARY KEY," +
                    DBContact.Soal.KOLOM_KATEGORI+" TEXT, " +
                    DBContact.Soal.KOLOM_SOAL+" TEXT, " +
                    DBContact.Soal.KOLOM_JAWABAN+" TEXT, " +
                    DBContact.Soal.KOLOM_PILIHAN1+" TEXT, " +
                    DBContact.Soal.KOLOM_PILIHAN2+" TEXT, " +
                    DBContact.Soal.KOLOM_PILIHAN3+" TEXT, " +
                    DBContact.Soal.KOLOM_PILIHAN4+" TEXT, " +
                    DBContact.Soal.KOLOM_PILIHAN5+" TEXT)"

        private  val SQL_DELETE_TABLE1 ="DROP TABLE IF EXIST " + DBContact.Soal.TABLE_NAME
    }
}