package com.example.biggernumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var tvPoints: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft = findViewById<Button>(R.id.btnLeft)
        btnRight = findViewById<Button>(R.id.btnRight)
        tvPoints = findViewById<TextView>(R.id.tvPoints)

        assignNumberstoButtons()

        btnLeft.setOnClickListener {
            checkAnswer(true)
        }

        btnRight.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun assignNumberstoButtons() {
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val isCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isCorrect) {
            points++
            Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show()
        } else {
            points--
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_LONG).show()
        }
        tvPoints.text = "Points: $points"
        assignNumberstoButtons()
    }
}