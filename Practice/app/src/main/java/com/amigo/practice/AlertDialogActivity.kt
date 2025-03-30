package com.amigo.practice

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
        val addContactDialog= AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Add Omi")
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton("Yes") { _,_->
                Toast.makeText(this, "Add Omi to contact", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _,_->
                Toast.makeText(this, "Omi not added to contact", Toast.LENGTH_SHORT).show()
            }.create()

        val options=arrayOf("First","Second","Third")
        val singleChoiceAlert= AlertDialog.Builder(this)
            .setTitle("Choose one")
            .setSingleChoiceItems (options,0){_,i->
                Toast.makeText(this, "You selected${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _,_->
                Toast.makeText(this, "You Accepted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Reject") { _,_->
                Toast.makeText(this, "You Rejected", Toast.LENGTH_SHORT).show()
            }.create()
        val multiChoiceAlert= AlertDialog.Builder(this)
            .setTitle("Choose Multiple")
            .setMultiChoiceItems(options,booleanArrayOf(false,false,false)){_,i,a->
                Toast.makeText(this, "${options[i] } Selected", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _,_->
                Toast.makeText(this, "You Accept", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Reject") { _,_->
                Toast.makeText(this, "You Rejected", Toast.LENGTH_SHORT).show()
            }.create()

        findViewById<Button>(R.id.btnAlertDialog1).setOnClickListener {
            addContactDialog.show()
        }
        findViewById<Button>(R.id.btnAlertDialog2).setOnClickListener {
            singleChoiceAlert.show()
        }
        findViewById<Button>(R.id.btnAlertDialog3).setOnClickListener {
            multiChoiceAlert.show()
        }
    }
}