package com.amigo.tablayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    val images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_layout,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewPagerViewHolder,
        position: Int
    ) {
        val curImage=images[position]
        holder.itemView.findViewById<ImageView>(R.id.ivImage).setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}