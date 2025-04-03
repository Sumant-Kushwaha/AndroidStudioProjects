package com.amigo.slidablemenu

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolBar=findViewById<Toolbar>(R.id.toolBar)
        val drawerLayout=findViewById<DrawerLayout>(R.id.main)
        val navigationView=findViewById<NavigationView>(R.id.navigationView)
        toggle= ActionBarDrawerToggle(this,drawerLayout,toolBar,R.string.Open,R.string.Close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1-> Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show()
                R.id.item2-> Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show()
                R.id.item3-> Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show()
                R.id.item4-> Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}