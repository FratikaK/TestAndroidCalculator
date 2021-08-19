package com.example.testandroidcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var result: String
        fun calcCation(firstStr: String, secondStr: String, calc: String): String {
            if (calc == "/" || calc == "*" || calc == "-" || calc == "+") {
                val firstNum = Integer.parseInt(firstStr)
                val secondNum = Integer.parseInt(secondStr)
                when (calc) {
                    "/" -> {
                        return "${firstNum / secondNum}"
                    }
                    "*" -> {
                        return "${firstNum * secondNum}"
                    }
                    "-" -> {
                        return "${firstNum - secondNum}"
                    }
                    "+" -> {
                        return "${firstNum + secondNum}"
                    }
                }
            }
            return "Error"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタンを取得する
        val button0 = findViewById<Button>(R.id.num0)
        val button1 = findViewById<Button>(R.id.num1)
        val button2 = findViewById<Button>(R.id.num2)
        val button3 = findViewById<Button>(R.id.num3)
        val button4 = findViewById<Button>(R.id.num4)
        val button5 = findViewById<Button>(R.id.num5)
        val button6 = findViewById<Button>(R.id.num6)
        val button7 = findViewById<Button>(R.id.num7)
        val button8 = findViewById<Button>(R.id.num8)
        val button9 = findViewById<Button>(R.id.num9)

        val buttonClear = findViewById<Button>(R.id.clear)
        val buttonDelete = findViewById<Button>(R.id.delete)
        val buttonDivide = findViewById<Button>(R.id.divide)
        val buttonMultiption = findViewById<Button>(R.id.multiption)
        val buttonSubtraction = findViewById<Button>(R.id.subtraction)
        val buttonAddition = findViewById<Button>(R.id.addition)
        val buttonResult = findViewById<Button>(R.id.result)

        //listenerの登録
        button0.setOnClickListener(NumberButtonClickListener())
        button1.setOnClickListener(NumberButtonClickListener())
        button2.setOnClickListener(NumberButtonClickListener())
        button3.setOnClickListener(NumberButtonClickListener())
        button4.setOnClickListener(NumberButtonClickListener())
        button5.setOnClickListener(NumberButtonClickListener())
        button6.setOnClickListener(NumberButtonClickListener())
        button7.setOnClickListener(NumberButtonClickListener())
        button8.setOnClickListener(NumberButtonClickListener())
        button9.setOnClickListener(NumberButtonClickListener())

        buttonClear.setOnClickListener(SignButtonClickListener())
        buttonDelete.setOnClickListener(SignButtonClickListener())
        buttonDivide.setOnClickListener(SignButtonClickListener())
        buttonMultiption.setOnClickListener(SignButtonClickListener())
        buttonSubtraction.setOnClickListener(SignButtonClickListener())
        buttonAddition.setOnClickListener(SignButtonClickListener())
        buttonResult.setOnClickListener(SignButtonClickListener())
    }

    /**
     * 数字ボタンをクリックした時の処理
     */
    inner class NumberButtonClickListener : View.OnClickListener {
        @SuppressLint("SetTextI18n")
        override fun onClick(v: View?) {
            if (v == null) {
                return
            }
            val getNum = findViewById<Button>(v.id).text
            var formula = findViewById<TextView>(R.id.formula)

            if (getNum.equals("0") && formula.text.equals("0")) {
                return
            }

            if (formula.text.equals("0")) {
                formula.text = getNum
                return
            }

            val builder = StringBuilder().append(formula.text)
            builder.append(getNum)

            formula.text = builder.toString()
            result = builder.toString()
        }
    }

    /**
     * 記号ボタンをクリックした時の処理
     */
    inner class SignButtonClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (v == null) {
                return
            }

            val getSignButton = findViewById<Button>(v.id).text
            val formula = findViewById<TextView>(R.id.formula)
            val subNum = findViewById<TextView>(R.id.subFormula)
            val sign = findViewById<TextView>(R.id.sign)

            if (getSignButton.equals("C")) {
                formula.text = "0"
                subNum.text = ""
                sign.text = ""
                result = ""
                return
            }else if (getSignButton.equals("DEL")){
                formula.text = "0"
                return
            }

            if (getSignButton.equals("RESULT") && subNum.text.equals("")){
                return
            }

            if (subNum.text.equals("")) {
                subNum.text = formula.text
                sign.text = getSignButton
                formula.text = "0"
            } else if (!subNum.text.equals("") && !getSignButton.equals("RESULT")) {
                sign.text = getSignButton
            } else {
                formula.text = calcCation(subNum.text as String, formula.text as String, sign.text as String)
                sign.text = ""
                subNum.text = ""
                result = ""
            }

        }
    }
}