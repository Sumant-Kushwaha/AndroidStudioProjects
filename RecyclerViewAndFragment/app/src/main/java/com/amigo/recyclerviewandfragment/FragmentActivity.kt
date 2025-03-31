package com.amigo.recyclerviewandfragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnFirstFragment).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, FirstFragment())
                addToBackStack(null)
                commit()
            }
        }
        findViewById<Button>(R.id.btnSecondFragment).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, SecondFragment())
                addToBackStack(null)
                commit()
            }
        }

    }
}