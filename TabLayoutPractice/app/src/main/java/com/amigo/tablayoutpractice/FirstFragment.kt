package com.amigo.tablayoutpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val tabLayout=view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(imageList)
        TabLayoutMediator(tabLayout,viewPager){tab,position->
            tab.text="Tab${position+1}"
        }.attach()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "${tab?.text} Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "${tab?.text} Unselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "${tab?.text} Reselected", Toast.LENGTH_SHORT).show()
            }

        })
        return view
    }

    val imageList=listOf(
        R.drawable.wallpaper1,
        R.drawable.wallpaper2,
        R.drawable.wallpaper3,
        R.drawable.wallpaper4,
        R.drawable.wallpaper5,
        R.drawable.wallpaper6
    )
}