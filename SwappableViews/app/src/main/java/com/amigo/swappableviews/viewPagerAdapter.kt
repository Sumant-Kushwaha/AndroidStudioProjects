package com.amigo.swappableviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class viewPagerAdapter (
    val images:List<Int>
):RecyclerView.Adapter<viewPagerAdapter.ViewPagerViewHolder>(){
    inner class ViewPagerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage=images[position]
        holder.itemView.findViewById<ImageView>(R.id.ivImage).setImageResource(curImage)
    }
}