package com.amigo.toolbarmenu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.appcompat.widget.Toolbar
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

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.icExit->finish()
            R.id.icSetting-> Intent(this, SettingActivity::class.java).also {
                startActivity(it)
            }
            R.id.icFeedback-> Toast.makeText(this, "Feedback Submitted", Toast.LENGTH_SHORT).show()
            R.id.icFavourite-> Toast.makeText(this, "Favourite Added", Toast.LENGTH_SHORT).show()
            R.id.icAddContact-> Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
