package com.example.testandroidcalculator

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.ArithmeticException
import java.lang.IllegalStateException

class ErrorDialogFragment(private val exceptionType: String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Error occurred")
            if (exceptionType == "ArithmeticException") {
                builder.setMessage("0で割ることはできません。")
            } else if (exceptionType == "NumberFormatException"){
                builder.setMessage("桁数が大きすぎるか、数字以外の計算によってエラーが発生しました。")
            }else{
                builder.setMessage("何らかのエラーが発生しました。")
            }
            builder.create()
        }
        return dialog ?: throw IllegalStateException("activity is null.")
    }
}