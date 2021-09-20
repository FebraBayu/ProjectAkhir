package com.example.proyekcadangan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_daftar_kuis.*
import kotlinx.android.synthetic.main.activity_kuis.*
import java.util.*

class Kuis : AppCompatActivity() {

    lateinit var db: UserDBHelper
//    var idQu: Array<String> = arrayOf("0", "1", "2", "3", "4","5","6","7","8","9")
//    var Sooall: Array<String> = arrayOf("Ubah bilangan biner berikut ini ke bilangan desimal (101101)", "Ubah bilangan biner berikut ini ke bilangan desimal (100110101)", "Ubah bilangan biner berikut ini ke bilangan desimal (1110110101)", "Ubah bilangan desimal berikut ini ke bilangan biner (63)", "Ubah bilangan desimal berikut ini ke bilangan biner (132)","Ubah bilangan desimal berikut ini ke bilangan biner (169)","Ubah bilangan Oktal berikut ini ke bilangan desimal (76)","Ubah bilangan Oktal berikut ini ke bilangan desimal (545)","Ubah bilangan Oktal berikut ini ke bilangan desimal (666)","Ubah bilangan desimal berikut ini ke bilangan oktal (31)")
//    var Pilihann1: Array<String> = arrayOf("40", "309", "937", "111111", "10101101","10101110","53","398","424","22")
//    var Pilihann2: Array<String> = arrayOf("45", "287", "952", "100101", "11001101","11100011","41","325","451","37")
//    var Pilihann3: Array<String> = arrayOf("50", "313", "943", "110110", "11111010","10111011","69","366","438","48")
//    var Pilihann4: Array<String> = arrayOf("55", "291", "949", "110100", "10000100","10101001","72","357","509","51")
//    var Pilihann5: Array<String> = arrayOf("25", "334", "968", "100011", "10110110","11011010","62","319","432","26")
//    var jawabnya: Array<String> = arrayOf("45", "309", "949", "111111", "10000100","10101001","62","357","438","37")
//    var score: Int = 0
//    var nomersoal: Int = 1
//    var xxx: Int = 0

    var idQu: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var Sooall: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var Pilihann1: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var Pilihann2: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var Pilihann3: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var Pilihann4: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var Pilihann5: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var jawabnya: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var score: Int = 0
    var nomersoal: Int = 1
    var xxx: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuis)
        supportActionBar?.hide()
        //val button: Button = findViewById(R.id.btnHome)
        btnHome.visibility = View.INVISIBLE

        btnHome.setOnClickListener({
            val intent : Intent = Intent(applicationContext,MainActivity::class.java)
            intent.putExtra("kategori", "Konversi")
            startActivity(intent)
        })

        db = UserDBHelper(this)
        var xiecie = getIntent().getStringExtra("kategori").toString();
        var Soaal = db.readAllSoal(xiecie)
        val random = Random()

        for (i: Int in 0..9) {
            //if (Soaal[i].kategori == xiecie) {
                val angka = random.nextInt(14)
                //val angka = i
                idQu.set(i, Soaal[angka].id)
                Sooall.set(i, Soaal[angka].soal)
                Pilihann1.set(i, Soaal[angka].pilihan1)
                Pilihann2.set(i, Soaal[angka].pilihan2)
                Pilihann3.set(i, Soaal[angka].pilihan3)
                Pilihann4.set(i, Soaal[angka].pilihan4)
                Pilihann5.set(i, Soaal[angka].pilihan5)
                jawabnya.set(i, Soaal[angka].jawaban)
            //}
        }
        score = 0
        nomersoal = 1
        xxx = 0
        UpdateSoal()

    }

    fun Lanjut(){
        nomersoal += 1
        xxx +=1
        if(xxx == 9){
//            val intent1: Intent = Intent(applicationContext, Score::class.java)
//            intent1.putExtra("TT", score.toString())
//            startActivity(intent1)
//            finish()
            Toast.makeText(this, "Kuis Selesai", Toast.LENGTH_SHORT).show()
            soal.text = ""
            buttonA.text = ""
            buttonB.text = ""
            buttonC.text = ""
            buttonD.text = ""
            buttonE.text = ""
            nomorsoal.text = ""
            scoretext.text = "Score : "+score.toString()
            btnHome.visibility = View.VISIBLE
            buttonA.visibility = View.INVISIBLE
            buttonB.visibility = View.INVISIBLE
            buttonC.visibility = View.INVISIBLE
            buttonD.visibility = View.INVISIBLE
            buttonE.visibility = View.INVISIBLE
            buttonA.isClickable = false
            buttonB.isClickable = false
            buttonC.isClickable = false
            buttonD.isClickable = false
            buttonE.isClickable = false
            return
            finish()
          }

        UpdateSoal()
    }
    fun buttonAClick(v: View){
        if (buttonA.text == jawabnya[xxx].toString()){
            score += 10
        }
        Lanjut()
    }
    fun buttonBClick(v: View){
        if (buttonB.text == jawabnya[xxx].toString()){
            score += 10
        }
        Lanjut()
    }
    fun buttonCClick(v: View){
        if (buttonC.text == jawabnya[xxx].toString()){
            score += 10
        }
        Lanjut()
    }
    fun buttonDClick(v: View){
        if (buttonD.text == jawabnya[xxx].toString()){
            score += 10
        }
        Lanjut()
    }

    fun buttonEClick(v: View){
        if (buttonE.text == jawabnya[xxx].toString()){
            score += 10
        }
        Lanjut()
    }

    fun UpdateSoal(){

        soal.text = Sooall[xxx].toString()
        buttonA.text = Pilihann1[xxx].toString()
        buttonB.text = Pilihann2[xxx].toString()
        buttonC.text = Pilihann3[xxx].toString()
        buttonD.text = Pilihann4[xxx].toString()
        buttonE.text = Pilihann5[xxx].toString()
        nomorsoal.text = "No.  "+ nomersoal.toString()
        //xxxtext.text = xxx.toString()
        scoretext.text = "Score : "+score.toString()
    }


}