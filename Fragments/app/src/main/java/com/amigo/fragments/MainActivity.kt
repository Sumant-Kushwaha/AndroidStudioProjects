package com.amigo.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

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
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment, firstFragment)
//            commit()
//        }

        findViewById<Button>(R.id.btnFirstFragment).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        findViewById<Button>(R.id.btnSecondFragment).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}