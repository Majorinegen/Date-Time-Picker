package com.example.datepickerdialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import java.util.Calendar
import javax.sql.RowSetListener

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var onDateSetListener: DatePickerDialog.OnDateSetListener

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.datepickerdialog1)
        editText.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            val month: Int = calendar.get(Calendar.MONTH)
            val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

            datePickerDialog =
                DatePickerDialog(this@MainActivity, onDateSetListener, year, month, day)
            datePickerDialog.show()
        }
        onDateSetListener =
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val updatedMonth = month + 1
                editText.setText("$dayOfMonth/$updatedMonth/$year")
            }
    }
}
