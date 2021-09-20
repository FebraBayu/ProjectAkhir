package com.example.proyekcadangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
        lateinit var db : UserDBHelper
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        db = UserDBHelper(this)
        var soals = db.readAllSoalMain()

            if (soals.count() == 0){
                InjectKonversi()
                InjectAritmatika()
                InjectKomplemen()
            }

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java )
            startActivity(intent)
            finish()
        }, 3000)





    }


    fun InjectKonversi(){
        var idQu: Array<String> = arrayOf("S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10","S11", "S12", "S13", "S14", "S15")
        var kategory: Array<String> = arrayOf("Konversi", "Konversi", "Konversi", "Konversi", "Konversi", "Konversi", "Konversi", "Konversi", "Konversi", "Konversi","Konversi", "Konversi", "Konversi", "Konversi", "Konversi")
        var Sooall: Array<String> = arrayOf("Ubah bilangan biner berikut ini ke bilangan desimal (101101)",
            "Ubah bilangan biner berikut ini ke bilangan desimal (100110101)",
            "Ubah bilangan biner berikut ini ke bilangan desimal (1110110101)",
            "Ubah bilangan desimal berikut ini ke bilangan biner (63)",
            "Ubah bilangan desimal berikut ini ke bilangan biner (132)",
            "Ubah bilangan desimal berikut ini ke bilangan biner (169)",
            "Ubah bilangan Oktal berikut ini ke bilangan desimal (76)",
            "Ubah bilangan Oktal berikut ini ke bilangan desimal (545)",
            "Ubah bilangan Oktal berikut ini ke bilangan desimal (666)",
            "Ubah bilangan desimal berikut ini ke bilangan oktal (31)",
            "Ubah bilangan desimal berikut ini ke bilangan oktal (231)",
            "Ubah bilangan desimal berikut ini ke bilangan oktal (231)",
            "Ubah bilangan desimal berikut ini ke bilangan oktal (876)",
            "Ubah bilangan oktal berikut ini menjadi bilangan biner (25)",
            "Ubah bilangan oktal berikut ini menjadi bilangan biner (375)",
            "Ubah bilangan oktal berikut ini menjadi bilangan biner (521)")
        var Pilihann1: Array<String> = arrayOf("40", "309", "937", "111111", "10101101","10101110","53","398","424","22","347","1352","11101","10110111","110101011")
        var Pilihann2: Array<String> = arrayOf("45", "287", "952", "100101", "11001101","11100011","41","325","451","37","389","1232","10110","1110001","10101110")
        var Pilihann3: Array<String> = arrayOf("50", "313", "943", "110110", "11111010","10111011","69","366","438","48","311","1287","11001","10001101","101010001")
        var Pilihann4: Array<String> = arrayOf("55", "291", "949", "110100", "10000100","10101001","72","357","509","51","234","1554","10001","11101101","100010111")
        var Pilihann5: Array<String> = arrayOf("25", "334", "968", "100011", "10110110","11011010","62","319","432","26","452","1456","10101","11111101","110101111")
        var jawabnya: Array<String> = arrayOf("45", "309", "949", "111111", "10000100","10101001","62","357","438","37","347","1554","10101","11111101","101010001")
        for (i: Int in 0..14){
            val result = db.AddSoal(Soal(idQu[i], kategory[i], Sooall[i], jawabnya[i], Pilihann1[i], Pilihann2[i], Pilihann3[i], Pilihann4[i],Pilihann5[i]))
        }
    }


    fun InjectAritmatika(){
        var idQu: Array<String> = arrayOf("S16", "S17", "S18", "S19", "S20", "S21", "S22", "S23", "S24", "S25","S26","S27","S28","S29","S30")
        var kategory: Array<String> = arrayOf("Aritmatika", "Aritmatika", "Aritmatika", "Aritmatika", "Aritmatika", "Aritmatika", "Aritmatika", "Aritmatika", "Aritmatika", "Aritmatika","Aritmatika","Aritmatika","Aritmatika","Aritmatika","Aritmatika")
        var Sooall: Array<String> = arrayOf("1010 + 101 =",
            "11011 + 10011 =",
            "101011 + 110111 =",
            "101110 - 1101 =",
            "1110 - 1001 =",
            "11001 - 10101 =",
            "101101 + 11100 + 10111 =",
            "1101101 + 10110 + 10101 =",
            "1111011 - 11111 - 1001 =",
            "10111000 - 1001101 - 111 =",
            "1101 * 1100 =",
            "1111 * 1010 =",
            "11110 % 11 =",
            "110110 % 101",
            "110 * 1101 % 1001 =")
        var Pilihann1: Array<String> = arrayOf("1111", "101101", "1010111", "110111", "111","101","1100000","10011000","11101011","10101101","1100100","11001011","1001","1010","1101")
        var Pilihann2: Array<String> = arrayOf("1101", "111011", "1100010", "11111", "110","111","1010110","11101011","10100111","1100100","11110011","100101111","1111","1001","1000")
        var Pilihann3: Array<String> = arrayOf("1110", "101110", "1111000", "100110", "101","1100","1111001","10001011","11101011","1110011","10011100","110100111","1110","1011","1110")
        var Pilihann4: Array<String> = arrayOf("1100", "101100", "1101110", "110011", "1110","100","1100001","10100111","11000001","1111101","11100101","10010110","1010","1111","1111")
        var Pilihann5: Array<String> = arrayOf("1011", "100001", "1100001", "100001", "1010","1110","1111000","10010100","1010011","10000101","11000100","10000011","1011","1101","1011")
        var jawabnya: Array<String> = arrayOf("1111", "101110", "1100010", "100001", "101","100","1100000","10011000","1010011","1100100","10011100","10010110","1010","1010","1000")
        for (i: Int in 0..14){
            val result = db.AddSoal(Soal(idQu[i], kategory[i], Sooall[i], jawabnya[i], Pilihann1[i], Pilihann2[i], Pilihann3[i], Pilihann4[i],Pilihann5[i]))
        }
    }

    fun InjectKomplemen(){
        var idQu: Array<String> = arrayOf("S31", "S32", "S33", "S34", "S35", "S36", "S37", "S38", "S39", "S30","S41","S42","S43","S45","S46")
        var kategory: Array<String> = arrayOf("Komplemen", "Komplemen", "Komplemen", "Komplemen", "Komplemen", "Komplemen", "Komplemen", "Komplemen", "Komplemen", "Komplemen","Komplemen","Komplemen","Komplemen","Komplemen","Komplemen")
        var Sooall: Array<String> = arrayOf("Komplemen 1 untuk 101100v2 adalah",
            "Komplemen 1 untuk 0,0110v2 adalah",
            "Komplemen 9 untuk 43210v10 adalah",
            "Komplemen 9 untuk 23,456v10 adalah",
            "Komplemen 1 untuk 11010111 adalah",
            "Komplemen 1 untuk 1110101 adalah",
            "Komplemen 2 untuk 11100 adalah",
            "Komplemen 2 untuk 00111101 adalah",
            "Komplemen 2 untuk 10110000 adalah",
            "Komplemen 2 untuk 101011101 adalah",
            "Komplemen 10 untuk 43210v10 adalah",
            "Komplemen 10 untuk 765,43v10",
            "Komplemen 9 untuk 712009 adalah",
            "Komplemen 9 untuk 871286 adalah",
            "Komplemen 10 untuk 617623 adalah")
        var Pilihann1: Array<String> = arrayOf("010011v2", "0,1101v2", "57831v10", "70,915v10", "11010110","1010010","11000","11000011","11101011","01010000","56229v10","234,92v10","287990","139085","872311")
        var Pilihann2: Array<String> = arrayOf("101111v2", "0,1001v2", "67123v10", "72,181v10", "11111011","0001111","10110","11101011","11000011","010100011","56283v10","872,57v10","293823","156892","146233")
        var Pilihann3: Array<String> = arrayOf("110110v2", "0,1111v2", "56789v10", "74,824v10", "00101000","1101011","11111","0010001","01010000","1110011","77613v10","325,12v10","323872","128713","412577")
        var Pilihann4: Array<String> = arrayOf("110001v2", "0,1110v2", "56766v10", "76,543v10", "10101101","0011101","00100","10100111","00000001","1111101","65128v10","234,57v10","512421","123451","382377")
        var Pilihann5: Array<String> = arrayOf("101101v2", "0,1010v2", "67489v10", "78,617v10", "10101010","0001010","110101","10010100","00010011","10000101","56790v10","123,86v10","232970","141528","534111")
        var jawabnya: Array<String> = arrayOf("010011v2", "0,1001v2", "56789v10", "76,543v10", "00101000","0001010","00100","11000011","01010000","010100011","56790v10","234,57v10","287990","128713","382377")
        for (i: Int in 0..14){
            val result = db.AddSoal(Soal(idQu[i], kategory[i], Sooall[i], jawabnya[i], Pilihann1[i], Pilihann2[i], Pilihann3[i], Pilihann4[i],Pilihann5[i]))
        }
    }




}