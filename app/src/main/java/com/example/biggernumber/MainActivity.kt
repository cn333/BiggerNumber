package com.example.biggernumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var tvPoints: TextView
    private lateinit var clBackground: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        tvPoints = findViewById(R.id.tvPoints)
        clBackground = findViewById(R.id.clBackground)

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
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            clBackground.setBackgroundColor(Color.GREEN)
        } else {
            points--
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()
            clBackground.setBackgroundColor(Color.RED)
        }
        tvPoints.text = "Points: $points"
        assignNumberstoButtons()
    }
}