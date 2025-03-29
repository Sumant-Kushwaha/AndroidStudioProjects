package com.amigo.alertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        val addContactAlert = AlertDialog.Builder(this)
            .setTitle("Add new Contact")
            .setMessage("Add Omi to Conatact")
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Omi added to contact list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton ("No") { _, _ ->
                Toast.makeText(this, "Omi not added to contact list", Toast.LENGTH_SHORT).show()
            }.create()

        findViewById<Button>(R.id.btnAlertDialog1).setOnClickListener {
            addContactAlert.show()
        }

        val options = arrayOf("First,", "Second", "Third", "Fourth")
        val chooseSingleChoiceAlert = AlertDialog.Builder(this)
            .setTitle("Choose one option")
            .setIcon(R.mipmap.ic_launcher)
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You clicked ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You Accepted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You Declined", Toast.LENGTH_SHORT).show()
            }.create()
        findViewById<Button>(R.id.btnAlertDialog2).setOnClickListener {
            chooseSingleChoiceAlert.show()
        }

        val multiChoiceOptionAlert = AlertDialog.Builder(this)
            .setTitle("Choose Multiple options")
            .setIcon(R.mipmap.ic_launcher)
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false,false)) { _, i, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Checked ${options[i]}", Toast.LENGTH_SHORT).show()
            }else{
                    Toast.makeText(this, "unChecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Yes") { _,_->
                Toast.makeText(this, "Accepted multiChoice", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _,_->
                Toast.makeText(this, "Rejected multiChoice", Toast.LENGTH_SHORT).show()
            }.create()
        findViewById<Button>(R.id.btnAlertDialog3).setOnClickListener {
            multiChoiceOptionAlert.show()
        }
    }
}