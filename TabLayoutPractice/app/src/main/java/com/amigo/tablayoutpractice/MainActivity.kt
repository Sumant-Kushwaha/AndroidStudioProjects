package com.amigo.tablayoutpractice

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        val toolbar: Toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        setCurrentFragment(FirstFragment())

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnItemSelectedListener {
            when(it.itemId){
                R.id.icHome->setCurrentFragment(FirstFragment())
                R.id.icTelephone->setCurrentFragment(SecondFragment())
                R.id.icSetting->setCurrentFragment(ThirdFragment())
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tab_layout,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.icExit->finish()
            R.id.icAlertDialog-> Intent(this, AlertDialog::class.java).also {
                startActivity(it)
            }
            R.id.icSpinner-> Intent(this, Spinner::class.java).also {
                startActivity(it)
            }
            R.id.icFeedback-> Toast.makeText(this, "Feedback Submitted", Toast.LENGTH_SHORT).show()
            R.id.icFavourite->Toast.makeText(this, "Favourite Added", Toast.LENGTH_SHORT).show()
            R.id.icAddContact->Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    private fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            addToBackStack(null)
            commit()
        }
    }
}