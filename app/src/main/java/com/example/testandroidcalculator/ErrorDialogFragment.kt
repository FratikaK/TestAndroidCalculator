package com.example.testandroidcalculator

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class ErrorDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Error occurred")
            builder.setMessage("NumberFormatExceptionが発生しました。")
            builder.create()
        }
        return dialog ?: throw IllegalStateException("activity is null.")
    }
}