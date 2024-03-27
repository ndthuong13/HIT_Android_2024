package com.example.btvn_buoi3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var currentValue = ""
    var result = 0.0
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initButtons()
        updateResult()
        updateView()
    }

    fun initButtons() {
        val buttons = arrayOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
            R.id.plus, R.id.minus, R.id.multiply, R.id.divide,
            R.id.equal, R.id.phay, R.id.clear
        )
        val changeminusButton = findViewById<Button>(R.id.changeminus)
        changeminusButton.setOnClickListener {
            toggleSign()
        }

        buttons.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener {
                handleButtonClick(it.id)
            }
        }
    }

    private fun toggleSign() {
        if (currentValue.isNotEmpty()) {
            currentValue = if (currentValue.startsWith("-")) {
                currentValue.substring(1)
            } else {
                "-$currentValue"
            }
            updateView()
        }
    }

    fun handleButtonClick(buttonId: Int) {
        when (buttonId) {
            R.id.button0 -> appendNumber("0")
            R.id.button1 -> appendNumber("1")
            R.id.button2 -> appendNumber("2")
            R.id.button3 -> appendNumber("3")
            R.id.button4 -> appendNumber("4")
            R.id.button5 -> appendNumber("5")
            R.id.button6 -> appendNumber("6")
            R.id.button7 -> appendNumber("7")
            R.id.button8 -> appendNumber("8")
            R.id.button9 -> appendNumber("9")
            R.id.plus-> appendOperator("+")
            R.id.minus -> appendOperator("-")
            R.id.multiply -> appendOperator("*")
            R.id.divide -> appendOperator("/")
            R.id.equal -> evaluateExpression()
            R.id.phay -> appendDot()
            R.id.clear -> clear()
        }
        updateView()
    }
    private fun appendNumber(number: String) {
        currentValue += number
        updateView()
    }
    fun appendDot() {
        if (!currentValue.contains(".")) {
            if (currentValue.isEmpty()) currentValue = "0"
            currentValue += "."
            updateView()
        }
    }

    fun appendOperator(op: String) {
        if (currentValue.isNotEmpty()) {
            operator += op
            currentValue += op
            updateView()
        }
    }

    fun clear() {
        currentValue = ""
        result = 0.0
        operator = ""
        updateResult()
        updateView()
    }

    fun evaluateExpression() {
        if (currentValue.isNotEmpty() && operator.isNotEmpty()) {
            val operands = currentValue.split(operator)
            if (operands.size == 2) {
                val val1 = operands[0].toDouble()
                val val2 = operands[1].toDouble()
                when (operator) {
                    "+" -> result = val1 + val2
                    "-" -> result = val1 - val2
                    "*" -> result = val1 * val2
                    "/" -> result = val1 / val2
                }
                operator = ""
                updateResult()
            }
        }
    }

    private fun updateView() {
        val textView = findViewById<TextView>(R.id.input)
        textView.text = "$currentValue"
    }

    private fun updateResult() {
        val textViewResult = findViewById<TextView>(R.id.result)
        textViewResult.text = result.toString()
    }
}