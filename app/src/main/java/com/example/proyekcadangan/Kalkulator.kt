package com.example.proyekcadangan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kalkulator.*

class Kalkulator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)
        supportActionBar?.hide()
    }

    fun Clear(v: View){
        txtBinary1.setText("")
        txtDecimal.setText("")
        txtOctal1.setText("")
        txtHexal.setText("")
    }

    fun Konvert(v: View) {

        if (this.txtHexal.text.toString() == "g" || this.txtHexal.text.toString() == "h" ||
            this.txtHexal.text.toString() == "i" || this.txtHexal.text.toString() == "j" || this.txtHexal.text.toString() == "k" || this.txtHexal.text.toString() == "l" ||
            this.txtHexal.text.toString() == "m" || this.txtHexal.text.toString() == "n" || this.txtHexal.text.toString() == "o" || this.txtHexal.text.toString() == "p" ||
            this.txtHexal.text.toString() == "q" || this.txtHexal.text.toString() == "r" || this.txtHexal.text.toString() == "s" || this.txtHexal.text.toString() == "t" ||
            this.txtHexal.text.toString() == "u" || this.txtHexal.text.toString() == "v" || this.txtHexal.text.toString() == "w" || this.txtHexal.text.toString() == "x" ||
            this.txtHexal.text.toString() == "y" || this.txtHexal.text.toString() == "z" ||
            this.txtHexal.text.toString() == "G" || this.txtHexal.text.toString() == "H" || this.txtHexal.text.toString() == "I" || this.txtHexal.text.toString() == "J" ||
            this.txtHexal.text.toString() == "K" || this.txtHexal.text.toString() == "l" ||
            this.txtHexal.text.toString() == "M" || this.txtHexal.text.toString() == "N" || this.txtHexal.text.toString() == "O" || this.txtHexal.text.toString() == "P" ||
            this.txtHexal.text.toString() == "Q" || this.txtHexal.text.toString() == "R" || this.txtHexal.text.toString() == "S" || this.txtHexal.text.toString() == "T" ||
            this.txtHexal.text.toString() == "U" || this.txtHexal.text.toString() == "V" || this.txtHexal.text.toString() == "W" || this.txtHexal.text.toString() == "X" ||
            this.txtHexal.text.toString() == "Y" || this.txtHexal.text.toString() == "Z") {
            Toast.makeText(this@Kalkulator,"Inputan anda tidak sesuai bilangan Hexadecimal !!!", Toast.LENGTH_SHORT).show()
            return
        }


        if (txtBinary1.text.isNotEmpty() && txtDecimal.text.isEmpty() && txtOctal1.text.isEmpty() && txtHexal.text.isEmpty()) {
            BinarytoDecimal(txtBinary1.text.toString().toLong())
            BinarytoOctal(txtBinary1.text.toString().toLong())
            BinarytoHexa(txtBinary1.text.toString().toLong())
        } else if (txtDecimal.text.isNotEmpty() && txtBinary1.text.isEmpty() && txtOctal1.text.isEmpty() && txtHexal.text.isEmpty()) {
            DecimaltoBinary(txtDecimal.text.toString().toInt())
            DecimaltoOctal(txtDecimal.text.toString().toInt())
            DecimaltoHexa(txtDecimal.text.toString().toInt())
        } else if (txtOctal1.text.isNotEmpty() && txtDecimal.text.isEmpty() && txtBinary1.text.isEmpty() && txtHexal.text.isEmpty()) {
            OctaltoDecimal(txtOctal1.text.toString().toInt())
            OctaltoBinary(txtOctal1.text.toString().toInt())
            OctaltoHexa(txtOctal1.text.toString().toInt())
        } else if (txtHexal.text.isNotEmpty() && txtBinary1.text.isEmpty() && txtDecimal.text.isEmpty() && txtOctal1.text.isEmpty()) {
            HexatoDecimal(txtHexal.text.toString())
            HexatoBinary(txtHexal.text.toString())
            HexatoOctal(txtHexal.text.toString())
        }else {
            Toast.makeText(this@Kalkulator,"Harap isi satu kolom saja!!!",Toast.LENGTH_SHORT).show()
        }


    }


    fun DecimaltoBinary(n: Int) {


        var n: Int = n
        var binaryNumber: Long = 0
        var remainder: Int
        var i = 1


        while (n != 0) {
            remainder = n % 2
            n /= 2
            binaryNumber += (remainder * i).toLong()
            i *= 10
        }
        txtBinary1.setText(binaryNumber.toString())
    }

    fun DecimaltoOctal(decimal: Int) {
        var decimal: Int = decimal
        var octalNumber1 = 0
        var i = 1

        while (decimal != 0) {
            octalNumber1 += decimal % 8 * i
            decimal /= 8
            i *= 10
        }
        txtOctal1.setText(octalNumber1.toString())
    }

    fun DecimaltoHexa(num: Int) {

//        print("Enter a decimal number : ")
        var num: Int = num
        // For storing remainder
        var rem: Int
        // For storing result
        var str2 = ""
        // Digits in hexadecimal number system
        val hex = charArrayOf(
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'A',
            'B',
            'C',
            'D',
            'E',
            'F'
        )
        while (num > 0) {
            rem = num % 16
            str2 = hex[rem].toString() + str2
            num = num / 16
        }
        //println("Method 2: Decimal to hexadecimal: $str2")
        txtHexal.setText(str2.toString())
    }

    fun BinarytoDecimal(num: Long) {

        var num: Long = num
        var decimalNumber: Int = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        txtDecimal.setText(decimalNumber.toString())
    }


    fun BinarytoOctal(numberBinary: Long) {

        var numberBinary: Long = numberBinary
        var octalNumber = 0
        var decimalNumber = 0
        var i = 0

        while (numberBinary.toInt() != 0) {
            decimalNumber += (numberBinary % 10 * Math.pow(2.0, i.toDouble())).toInt()
            ++i
            numberBinary /= 10
        }

        i = 1

        while (decimalNumber != 0) {
            octalNumber += decimalNumber % 8 * i
            decimalNumber /= 8
            i *= 10
        }
        txtOctal1.setText(octalNumber.toString())
    }

    fun BinarytoHexa(m: Long) {

        var Angka2: Long = m
        BinarytoDecimal(Angka2)
        DecimaltoHexa(txtDecimal.text.toString().toInt())

    }


    fun OctaltoDecimal(octal: Int){

            var octal: Int = octal
            var decimalNumber = 0
            var i = 0

            while (octal != 0) {
                decimalNumber += (octal % 10 * Math.pow(8.0, i.toDouble())).toInt()
                ++i
                octal /= 10
            }
        txtDecimal.setText(decimalNumber.toString())
    }

    fun OctaltoBinary(octalNumber: Int){

            var octalNumber = octalNumber
            var decimalNumber = 0
            var i = 0
            var binaryNumber: Long = 0

            while (octalNumber != 0) {
                decimalNumber += (octalNumber % 10 * Math.pow(8.0, i.toDouble())).toInt()
                ++i
                octalNumber /= 10
            }

            i = 1

            while (decimalNumber != 0) {
                binaryNumber += (decimalNumber % 2 * i).toLong()
                decimalNumber /= 2
                i *= 10
            }

        txtBinary1.setText(binaryNumber.toString())
    }

    fun OctaltoHexa(x: Int){

        var Angka3: Int = x
        OctaltoDecimal(Angka3)
        DecimaltoHexa(txtDecimal.text.toString().toInt())

    }

    fun HexatoDecimal(hexaDecimalN: String){

        val hexaDecimalN: String = hexaDecimalN
        if(checkHexaDecimalNumber(hexaDecimalN!!)) {

            var i = hexaDecimalN.length - 1
            var decimalN: Long = 0
            var base = 1
            while(i >= 0) {
                val charAtPos = hexaDecimalN[i]

                val lastDigit = if((charAtPos >= '0') && (charAtPos <= '9')) {
                    charAtPos - '0'
                } else if((charAtPos >= 'A') && (charAtPos <= 'F')) {
                    charAtPos.toInt() - 55
                } else if((charAtPos >= 'a') && (charAtPos <= 'f')) {
                    charAtPos.toInt() - 87
                } else {
                    0
                }

                decimalN += lastDigit * base
                base *= 16

                i--
            }
            txtDecimal.setText(decimalN.toString())
            //println("Equivalent HexaDecimal : $decimalN")
        }
    }

    private fun checkHexaDecimalNumber(hexaDecimalNum: String): Boolean {
        var isHexaDecimalNum = true

        for(charAtPos in hexaDecimalNum) {
            if(!(
                        ((charAtPos >= '0') && (charAtPos <= '9'))
                                || ((charAtPos >= 'A') && (charAtPos <= 'F'))
                                || ((charAtPos >= 'a') && (charAtPos <= 'f'))
                        )) {
                isHexaDecimalNum = false
                break
            }
        }
        return isHexaDecimalNum


    }

    fun HexatoBinary(hexaDecimalN: String){

        val hexaDecimalN: String = hexaDecimalN
        if(checkHexaDecimalNumber2(hexaDecimalN)) {

            var i = 0
            var binaryNum = ""
            while(i < hexaDecimalN.length) {
                when(hexaDecimalN[i]) {
                    '0'  -> binaryNum += "0000"
                    '1'  -> binaryNum += "0001"
                    '2'  -> binaryNum += "0010"
                    '3'  -> binaryNum += "0011"
                    '4'  -> binaryNum += "0100"
                    '5'  -> binaryNum += "0101"
                    '6'  -> binaryNum += "0110"
                    '7'  -> binaryNum += "0111"
                    '8'  -> binaryNum += "1000"
                    '9'  -> binaryNum += "1001"
                    'A', 'a'  -> binaryNum += "1010"
                    'B', 'b'  -> binaryNum += "1011"
                    'C', 'c'  -> binaryNum += "1100"
                    'D', 'd'  -> binaryNum += "1101"
                    'E', 'e'  -> binaryNum += "1110"
                    'F', 'f'  -> binaryNum += "1111"
                }
                i++
            }
            txtBinary1.setText(binaryNum)
        }
    }

    private fun checkHexaDecimalNumber2(hexaDecimalNum: String): Boolean {
        var isHexaDecimalNum = true

        for(charAtPos in hexaDecimalNum) {
            if(!(
                        ((charAtPos >= '0') && (charAtPos <= '9'))
                                || ((charAtPos >= 'A') && (charAtPos <= 'F'))
                                || ((charAtPos >= 'a') && (charAtPos <= 'f'))
                        )) {
                isHexaDecimalNum = false
                break
            }
        }
        return isHexaDecimalNum


    }

    fun HexatoOctal(n: String){

    var Angka: String = n
        HexatoDecimal(Angka)
        DecimaltoOctal(txtDecimal.text.toString().toInt())

    }

//    fun main(args: Array<String>) {
//        val num: Long = 110110111
//        val decimal = convertBinaryToDecimal(num)
//        println("$num in binary = $decimal in decimal")
//    }

//    fun convertBinaryToDecimal(num: Long): Int {
//        var num = num
//        var decimalNumber = 0
//        var i = 0
//        var remainder: Long
//
//        while (num.toInt() != 0) {
//            remainder = num % 10
//            num /= 10
//            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
//            ++i
//        }
//        return decimalNumber
//    }
//
//    fun convertDecimalToBinary(args: Array<String>) {
//        val num = 19
//
//        // converting decimal to binary
//        val binary = Integer.toBinaryString(num)
//        println("$num in decimal = $binary in binary")
//    }


}