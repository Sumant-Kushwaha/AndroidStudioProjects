package com.amigo.shareprefpractice

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
        val sharedPref=getSharedPreferences("myPref",MODE_PRIVATE)
        val editor=sharedPref.edit()

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val name=findViewById<EditText>(R.id.etName).text.toString()
            val age=findViewById<EditText>(R.id.etAge).text.toString().toInt()
            val isAdult=findViewById<CheckBox>(R.id.cbAdult).isChecked

            editor.apply {
                putString("name",name)
                putInt("age",age)
                putBoolean("adult",isAdult)
                apply()
            }

            Toast.makeText(this, "Data saved...", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnLoad).setOnClickListener {
            val name=sharedPref.getString("name",null)
            val age=sharedPref.getInt("age",0)
            val isAdult=sharedPref.getBoolean("adult",false)

            findViewById<EditText>(R.id.etName).setText(name)
            findViewById<EditText>(R.id.etAge).setText(age.toString())
            findViewById<CheckBox>(R.id.cbAdult).isChecked=isAdult

            Toast.makeText(this, "Data loaded...", Toast.LENGTH_SHORT).show()
        }
    }
}