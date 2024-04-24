package com.ST10446912.imadcalculater


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    var etNumber : EditText? = null
    var tvOutput : TextView? = null
    var tvOutput2 : TextView? = null
    var arrNumbers = Array<Int>(10) { 0 }
    var intCount = 0
    var intSum = 0
    var intHigh: Int = 0
    var intLow: Int = 0
    var dblAvg: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        etNumber = findViewById(R.id.etNumber)
        tvOutput = findViewById(R.id.tvOutput)
        tvOutput2 = findViewById(R.id.tvOutput2)


        val btnAddToList = findViewById<Button>(R.id.btnAddToList)
        btnAddToList.setOnClickListener {
            if (intCount < 10) {
                arrNumbers[intCount] = etNumber?.text.toString().toInt()

                var strOutput: String? = ""
                for (i in 0..intCount) {
                    strOutput = strOutput + arrNumbers[i].toString()
                }

                tvOutput?.text = strOutput
                intCount = intCount + 1
            } else {
                etNumber?.error = "Input limit reached (10 numbers) "
            }
        }


        val btnTotal = findViewById<Button>(R.id.btnTotal)
        btnTotal.setOnClickListener {
            intSum = 0
            for (i in 0..(intCount - 1)) {
                intSum = intSum + arrNumbers[i]
            }
            tvOutput2?.text = "The total is $intSum"

        }


        val btnHigh = findViewById<Button>(R.id.btnHigh)
        btnHigh.setOnClickListener {
            intHigh = -1
            for (i in 0..(intCount - 1)) {
                if (arrNumbers[i] > intHigh){
                intHigh = arrNumbers[i]
                }
            }
            tvOutput2?.text = "The highest number is intHigh"
        }


        val btnLow = findViewById<Button>(R.id.btnLow)
        btnLow.setOnClickListener {
            intLow = 999
            for (i in 0..(intCount - 1)) {
                if (arrNumbers[i] < intLow){
                    intHigh = arrNumbers[i]
                }
            }
            tvOutput2?.text = "The lowest number is intLow"
        }


        val btnAverage = findViewById<Button>(R.id.btnAverage)
        btnAverage.setOnClickListener {
            intSum = 0
            for (i in 0..(intCount - 1)) {
                intSum = intSum + arrNumbers[i]
            }
            tvOutput2?.text = "The average is $dblAvg"
        }
        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            for (i in 0..9 ) {
                arrNumbers[i] = 0
            }
            tvOutput?.text = ""
            tvOutput2?.text = ""

            //arrNumbers.clear()
        }
    }
}
