package com.amigo.tablayoutpractice

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert_dialog)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addContact= AlertDialog.Builder(this)
            .setTitle("Add New Contact")
            .setMessage("Add Omi to Contact List")
            .setIcon(R.mipmap.ic_launcher)
            .setNegativeButton ("No"){_,_->
                Toast.makeText(this, "Contact Not Added", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton ("Yes"){_,_->
                Toast.makeText(this, "Contact  Added", Toast.LENGTH_SHORT).show()
            }.create()

        val options=arrayOf("First","Second","Third")
        val singleChoice= AlertDialog.Builder(this)
            .setTitle("Choose one option")
            .setIcon(R.mipmap.ic_launcher)
            .setSingleChoiceItems(options,0){ _,i->
                Toast.makeText(this, "${options[i]} selected", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton ("Reject"){_,_->
                Toast.makeText(this, "Rejected...", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton ("Accept"){_,_->
                Toast.makeText(this, "Accepted...", Toast.LENGTH_SHORT).show()
            }.create()

        val multiOptionAlertDialog= AlertDialog.Builder(this)
            .setTitle("Choose Multiple options")
            .setIcon(R.mipmap.ic_launcher)
            .setMultiChoiceItems (options,booleanArrayOf(false,false,false)){ _,i,a->
                Toast.makeText(this, "${options[i]} selected", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton ("Reject"){_,_->
                Toast.makeText(this, "Rejected...", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton ("Accept"){_,_->
                Toast.makeText(this, "Accepted...", Toast.LENGTH_SHORT).show()
            }.create()

        findViewById<Button>(R.id.btnAlertDialog1).setOnClickListener {
            addContact.show()
        }
        findViewById<Button>(R.id.btnAlertDialog2).setOnClickListener {
            singleChoice.show()
        }
        findViewById<Button>(R.id.btnAlertDialog3).setOnClickListener {
            multiOptionAlertDialog.show()
        }
    }
}