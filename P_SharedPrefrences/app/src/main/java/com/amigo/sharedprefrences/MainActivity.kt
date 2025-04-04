package com.amigo.sharedprefrences

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val cbAdult = findViewById<CheckBox>(R.id.cbAdult)
        val btnLoad = findViewById<Button>(R.id.btnLoad)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val sharePref = getSharedPreferences("PersonalDetail", MODE_PRIVATE)
        val editor = sharePref.edit()

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val adult = cbAdult.isChecked

            editor.apply {
                putString("NAME", name)
                putInt("AGE", age)
                putBoolean("ADULT", adult)
                apply()
            }
            Toast.makeText(this, "Data saved...", Toast.LENGTH_SHORT).show()
        }
        btnLoad.setOnClickListener {
            val name = sharePref.getString("NAME", null)
            val age=sharePref.getInt("AGE",12)
            val adult=sharePref.getBoolean("ADULT",false)

            etName.setText(name)
            etAge.setText(age.toString())
            cbAdult.isChecked=adult

            Toast.makeText(this, "Data loaded...", Toast.LENGTH_SHORT).show()
        }
    }
}