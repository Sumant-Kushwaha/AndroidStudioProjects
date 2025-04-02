package com.amigo.swappableviews

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

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
        val imageList= listOf(
            R.drawable.wallpaper75,
            R.drawable.wallpaper76,
            R.drawable.wallpaper77,
            R.drawable.wallpaper78,
            R.drawable.wallpaper79,
            R.drawable.wallpaper80,
            R.drawable.wallpaper81,
            R.drawable.wallpaper82
        )

        val adapter=viewPagerAdapter(imageList)
        val vpPager=findViewById<ViewPager2>(R.id.vpPager)

        vpPager.adapter=adapter
        vpPager.orientation= ViewPager2.ORIENTATION_VERTICAL

        vpPager.beginFakeDrag()
        vpPager.fakeDragBy(-10f)
        vpPager.endFakeDrag()

    }
}