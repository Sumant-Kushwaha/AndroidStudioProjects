package com.amigo.cbandrb

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
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
        val cbCucumber = findViewById<CheckBox>(R.id.cbCucumber)
        val cbOnion = findViewById<CheckBox>(R.id.cbOnion)
        val cbTikki = findViewById<CheckBox>(R.id.cbTikki)

        val rgMeat = findViewById<RadioGroup>(R.id.rgMeat)

        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            val meat = rgMeat.checkedRadioButtonId
            if(meat==-1){
                Toast.makeText(this, "Select meat first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val meatId = findViewById<RadioButton>(meat)

            val cucumber = cbCucumber.isChecked
            val onion = cbOnion.isChecked
            val tikki = cbTikki.isChecked

            val orderString = "You have ordered a burger with :\n" +
                    "${meatId.text}\n"+
                    "${if (cucumber) "cucumber\n" else ""}"+
                    "${if (onion) "onion\n" else ""}"+
                    "${if (tikki) "tikki\n" else ""}"

            findViewById<TextView>(R.id.tvOrder).text= orderString


        }
    }
}